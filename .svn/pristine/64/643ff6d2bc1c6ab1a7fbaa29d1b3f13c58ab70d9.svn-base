/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.transformerbean;

import com.argusoft.armms.core.SvnService;
import com.argusoft.armms.model.SvnDetail;
import com.argusoft.armms.model.SvnFileDetails;
import com.argusoft.armms.web.databean.ProjectDataBean;
import com.argusoft.armms.web.databean.SvnDataBean;
import com.argusoft.armms.web.databean.SvnFileDataBean;
import com.argusoft.armms.web.servicebean.ProjectServiceBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * Transformer Bean for SVN
 * @author ravi
 */
@ManagedBean(name = "svnTransformerBean")
@RequestScoped
public class SvnTransformerBean {

    @ManagedProperty("#{svnService}")
    private SvnService svnService;

    @ManagedProperty("#{projectDataBean}")
    private ProjectDataBean projectDataBean;

    @ManagedProperty("#{projectServiceBean}")
    private ProjectServiceBean projectServiceBean;

    @ManagedProperty("#{projectTransformerBean}")
    private ProjectTransformerBean projectTransformerBean;

    public SvnService getSvnService() {
        return svnService;
    }

    public void setSvnService(SvnService svnService) {
        this.svnService = svnService;
    }

    public ProjectDataBean getProjectDataBean() {
        return projectDataBean;
    }

    public void setProjectDataBean(ProjectDataBean projectDataBean) {
        this.projectDataBean = projectDataBean;
    }

    public ProjectServiceBean getProjectServiceBean() {
        return projectServiceBean;
    }

    public void setProjectServiceBean(ProjectServiceBean projectServiceBean) {
        this.projectServiceBean = projectServiceBean;
    }

    public ProjectTransformerBean getProjectTransformerBean() {
        return projectTransformerBean;
    }

    public void setProjectTransformerBean(ProjectTransformerBean projectTransformerBean) {
        this.projectTransformerBean = projectTransformerBean;
    }

    /**     
     * to retrieve the last updated revision number related to particular project 
     * @author ravi
     * @param projectId project Id
     * @return
     */
    public Long retrieveLastupdatedRevisionNumber(Long projectId) {
        return svnService.retrieveLastupdatedRevisionNumber(projectId);
    }

    /**
     * retrieve list of Data Beans which are related to this Id
     * @author ravi
     * @param id SvnDetail Id
     * @return List of SvnDataBean
     */
    public List<SvnDataBean> retrieveSvnDataById(Long id){
        List<SvnDetail> svnDetails = svnService.retrieveListById(id,Boolean.TRUE);
        List<SvnDataBean> svnDataBeans = new ArrayList<>();
        for (SvnDetail svnDetail : svnDetails) {            
            svnDataBeans.add(convertSvnDetailTosvnDatabean(svnDetail));
        }
        return svnDataBeans;
    }
    
    /**
     * retrieve list of Data Beans which are related to this project Id
     * @author ravi
     * @param projectId project Id
     * @return List of SvnDataBean
     */
    public List<SvnDataBean> retrieveSvnDataByProjectId(long projectId){
        List<SvnDetail> svnDetails = svnService.retrieveListByProjectId(projectId, Boolean.TRUE);
        List<SvnDataBean> svnDataBeans = new ArrayList<>();
        for (SvnDetail svnDetail : svnDetails) {
            svnDataBeans.add(convertSvnDetailTosvnDatabean(svnDetail));
        }
        return svnDataBeans;
    }
    
    /**
     * retrieve list of Data Beans which are related to this Task Id
     * @author ravi
     * @param taskId task Id
     * @return List of SvnDataBean
     */
    public List<SvnDataBean> retrieveSvnDataByTaskId(String taskId){
        List<SvnDetail> svnDetails = svnService.retrieveListByTaskId(taskId, Boolean.TRUE);
        List<SvnDataBean> svnDataBeans = new ArrayList<>();
        for (SvnDetail svnDetail : svnDetails) {
            svnDataBeans.add(convertSvnDetailTosvnDatabean(svnDetail));
        }
        return svnDataBeans;
    }

    public SvnDetail convertsvnDatabeanToSvnDetail(SvnDataBean svnDataBean) {
        SvnDetail svnDetail = new SvnDetail();
        svnDetail.setProjectId(svnDataBean.getProjectId());
        svnDetail.setRevisionNo(svnDataBean.getRevisionNo());
        svnDetail.setTaskId(svnDataBean.getTaskId());
        svnDetail.setComment(svnDataBean.getComments());
        svnDetail.setCommiter(svnDataBean.getCommiter());
        svnDetail.setCommitedOn(svnDataBean.getCommitedOn());
        List<SvnFileDataBean> svnFileDataBeans = svnDataBean.getSvnFileDataBeans();
        if (svnFileDataBeans != null && !svnFileDataBeans.isEmpty()) {
            List<SvnFileDetails> svnFileDetails = new ArrayList<>();
            for (SvnFileDataBean svnFileDataBean : svnFileDataBeans) {
                SvnFileDetails svnFileDetail = convertSvnFileDatabeanToSvnFileDetail(svnFileDataBean);
                svnFileDetail.setSvnDetail(svnDetail);
                svnFileDetails.add(svnFileDetail);
            }
            svnDetail.setSvnFileDetails(svnFileDetails);
        }
        return svnDetail;

    }

    public SvnDataBean convertSvnDetailTosvnDatabean(SvnDetail svnDetail){
        SvnDataBean svnDataBean = new SvnDataBean();
        svnDataBean.setId(svnDetail.getId());
        svnDataBean.setProjectId(svnDetail.getProjectId());
        svnDataBean.setRevisionNo(svnDetail.getRevisionNo());
        svnDataBean.setTaskId(svnDetail.getTaskId());
        svnDataBean.setComments(svnDetail.getComment());
        svnDataBean.setCommiter(svnDetail.getCommiter());
        svnDataBean.setCommitedOn(svnDetail.getCommitedOn());
        List<SvnFileDataBean> svnFileDataBeans = new ArrayList<>();
        try {
            List<SvnFileDetails> svnFileDetails = svnDetail.getSvnFileDetails();
            if (svnFileDetails != null && !svnFileDetails.isEmpty()) {
                for (SvnFileDetails svnFileDetail : svnFileDetails) {
                    SvnFileDataBean svnFileDatabean = convertSvnFileDetailToSvnFileDatabean(svnFileDetail);
                    svnFileDataBeans.add(svnFileDatabean);
                }
            }
        } catch (Exception e) {

        }
        svnDataBean.setSvnFileDataBeans(svnFileDataBeans);
        return svnDataBean;

    }

    public SvnFileDetails convertSvnFileDatabeanToSvnFileDetail(SvnFileDataBean svnFileDataBean){
        SvnFileDetails svnFileDetails = new SvnFileDetails();
        svnFileDetails.setFilePath(svnFileDataBean.getFilePath());
        svnFileDetails.setChangeType(svnFileDataBean.getChangeType());
        svnFileDetails.setPathType(svnFileDataBean.getPathType());
        return svnFileDetails;

    }

    public SvnFileDataBean convertSvnFileDetailToSvnFileDatabean(SvnFileDetails svnFileDetails){
        SvnFileDataBean svnFileDataBean = new SvnFileDataBean();
        svnFileDataBean.setFilePath(svnFileDetails.getFilePath());
        svnFileDataBean.setChangeType(svnFileDetails.getChangeType());
        svnFileDataBean.setPathType(svnFileDetails.getPathType());
        return svnFileDataBean;

    }

    /**
     * Adds the List of Data to DataBase     
     * @author ravi
     * @param listOfSvnData list of data to be Added in DataBase
     */
    public void populateSvnDataRepository(List<SvnDataBean> listOfSvnData){
        List<SvnDetail> svnDetails = new ArrayList<>();

        for (Iterator<SvnDataBean> svnData = listOfSvnData.iterator(); svnData.hasNext();) {
            svnDetails.add(convertsvnDatabeanToSvnDetail(svnData.next()));
        }

        svnService.addSvnData(svnDetails);
    }

}
