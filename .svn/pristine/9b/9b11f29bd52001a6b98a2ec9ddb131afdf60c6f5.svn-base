/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.core.ProjectService;
import com.argusoft.armms.core.SvnService;
import com.argusoft.armms.model.Project;
import com.argusoft.armms.model.SvnDetail;
import com.argusoft.armms.model.SvnFileDetails;
import com.argusoft.usermanagement.common.exception.UMUserManagementException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * Scheduler for updating Svn Repository
 *
 * @author ravi
 */
@Component
public class SvnRepositoryScheduler {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SvnService svnService;

    public List<SvnDetail> populateListOfSvnData(long projectId, String svnUrl) {
        List<SvnDetail> svnDetails = new ArrayList<>();
        Long Startfrom = svnService.retrieveLastupdatedRevisionNumber(projectId) + 1;

        DAVRepositoryFactory.setup();

        SVNRepository repository = null;
        try {
            repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(svnUrl));
        } catch (SVNException ex) {
            System.out.println("-----------No implementation for the specified protocol----------");
            return svnDetails;
        }

        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("rparikh", "rparikh@786");

        repository.setAuthenticationManager(authManager);
        long latestRevision = Startfrom;
        try {
            latestRevision = repository.getLatestRevision();
        } catch (SVNException ex) {
            System.out.println("----------------Failure occured while connecting to a repository or the user's authentication failed for latest revision------------");
            return svnDetails;
        }
        if ((Startfrom - 1) == latestRevision) {
//            System.out.println("project id :" + projectId + "already updated");
        } else {

            Collection logEntries = null;
            try {
                logEntries = repository.log(new String[]{""}, null,
                        Startfrom, latestRevision, true, true);
            } catch (SVNException ex) {
                System.out.println("-------Failure occured while connecting to a repository or the user's authentication failed for log entries----------");
                return svnDetails;
            }

            logEntries.size();
            for (Iterator entries = logEntries.iterator(); entries.hasNext();) {
                SVNLogEntry logEntry = (SVNLogEntry) entries.next();
                long revisionNo = logEntry.getRevision();
                SvnDetail svnDetail = new SvnDetail();
                svnDetail.setRevisionNo(revisionNo);
                svnDetail.setCommiter(logEntry.getAuthor());
                svnDetail.setCommitedOn(logEntry.getDate());
                String message = logEntry.getMessage();
                if (message.contains(":")) {
                    String split[] = message.split(":");
                    if (split[0].contains("-")) {
                        svnDetail.setTaskId(split[0]);
                        svnDetail.setComment(split[1]);
                    } else {
                        svnDetail.setComment(message);
                    }
                } else {
                    svnDetail.setComment(message);
                }
                svnDetail.setProjectId(projectId);

                if (logEntry.getChangedPaths().size() > 0) {

                    Set changedPathsSet = logEntry.getChangedPaths().keySet();
                    List<SvnFileDetails> svnFileDetails = new ArrayList<>();
                    for (Iterator changedPaths = changedPathsSet.iterator(); changedPaths.hasNext();) {
                        SVNLogEntryPath entryPath = (SVNLogEntryPath) logEntry.getChangedPaths().get(changedPaths.next());
                        SvnFileDetails svnFileDetail = new SvnFileDetails();
                        svnFileDetail.setFilePath(entryPath.getPath());
                        svnFileDetail.setPathType(entryPath.getKind().toString());
                        svnFileDetail.setSvnDetail(svnDetail);
                        if (entryPath.getType() == 'A') {
                            svnFileDetail.setChangeType("Added");
                        }
                        if (entryPath.getType() == 'D') {
                            svnFileDetail.setChangeType("Deleted");
                        }
                        if (entryPath.getType() == 'M') {
                            svnFileDetail.setChangeType("Modified");
                        }
                        if (entryPath.getType() == 'R') {
                            svnFileDetail.setChangeType("Replaced");

                        }
                        svnFileDetails.add(svnFileDetail);

                    }
                    svnDetail.setSvnFileDetails(svnFileDetails);
                }
                svnDetails.add(svnDetail);
            }
        }
        return svnDetails;
    }

    @Scheduled(fixedRate = (5 * 60000))
    public void syncSvnRepository() throws UMUserManagementException {
        List<Project> ActiveProjects = projectService.retrieveActiveOrInactiveProjects(true);
        List<SvnDetail> svnDetails = new ArrayList<>();

        for (Project projectData : ActiveProjects) {
            if (projectData.getSvnUrl() != null && !projectData.getSvnUrl().isEmpty() ) {
                System.out.println("Repository Updated Project Id::::::::::" + projectData.getProjectId());
                List<SvnDetail> populateListOfSvnData = populateListOfSvnData(projectData.getProjectId(), projectData.getSvnUrl());
                if (populateListOfSvnData.isEmpty()) {
                } else {
                    svnDetails.addAll(populateListOfSvnData);
                }
            }
        }
        if (!svnDetails.isEmpty()) {
            svnService.addSvnData(svnDetails);
        }

    }
}
