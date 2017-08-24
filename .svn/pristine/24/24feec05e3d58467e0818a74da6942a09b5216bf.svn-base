package com.argusoft.armms.web.servicebean;

import com.argusoft.armms.web.databean.FolderDataBean;
import com.argusoft.armms.web.databean.SvnDataBean;
import com.argusoft.armms.web.databean.SvnFileDataBean;
import com.argusoft.armms.web.transformerbean.SvnTransformerBean;
import com.argusoft.armms.web.util.SystemResultSessionUtil;
import com.argusoft.armms.web.util.SystemResultViewUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * service bean for folder structure
 * @author ravi
 */
@ManagedBean(name = "folderServiceBean")
@RequestScoped
public class FolderServiceBean {

    @ManagedProperty("#{systemResultViewUtil}")
    private SystemResultViewUtil systemResultViewUtil;

    @ManagedProperty("#{systemResultSessionUtil}")
    private SystemResultSessionUtil systemResultSessionUtil;

    @ManagedProperty("#{svnTransformerBean}")
    private SvnTransformerBean svnTransformerBean;
    
    public List<FolderDataBean> listData = new ArrayList<>();

    public SystemResultSessionUtil getSystemResultSessionUtil() {
        return systemResultSessionUtil;
    }

    public void setSystemResultSessionUtil(SystemResultSessionUtil systemResultSessionUtil) {
        this.systemResultSessionUtil = systemResultSessionUtil;
    }

    public SystemResultViewUtil getSystemResultViewUtil() {
        return systemResultViewUtil;
    }

    public void setSystemResultViewUtil(SystemResultViewUtil systemResultViewUtil) {
        this.systemResultViewUtil = systemResultViewUtil;
    }

    public SvnTransformerBean getSvnTransformerBean() {
        return svnTransformerBean;
    }

    public void setSvnTransformerBean(SvnTransformerBean svnTransformerBean) {
        this.svnTransformerBean = svnTransformerBean;
    }   

    public List<FolderDataBean> getListData() {
        return listData;
    }

    public void setListData(List<FolderDataBean> list) {
        listData = list;
    }
    
    /**
     * 
     * generate list of FolderDataBean
     * @author ravi
     */
    private void getFolderStructure(List<SvnFileDataBean> fileList, int level) {
        //recursive function to genarate list of folder data bean
        int j=0;
        if (!fileList.isEmpty()) {
            SvnFileDataBean svnFileDataBean = fileList.get(j);
            j++;
            String get = svnFileDataBean.getFilePath();
            String[] split = get.split("/");

            String key = null;
            try {
                key = "/" + split[1] + "/";
            } catch (Exception e) {
                System.out.println("split[1] throw exception");
                return;
            }

            FolderDataBean folderDataBean = new FolderDataBean();

            List<SvnFileDataBean> list = new ArrayList<>();
            folderDataBean.setKey(key.replace("/", ""));
            folderDataBean.setLevel(level * 20);
            if (key.length() == get.length()) {
                folderDataBean.setType(svnFileDataBean.getChangeType());
                folderDataBean.setKeyType(svnFileDataBean.getPathType());
            } else {
                folderDataBean.setType("Folder");
                folderDataBean.setKeyType("dir");
            }
            listData.add(folderDataBean);
            int cnt = 0;

            for (Iterator<SvnFileDataBean> value = fileList.iterator(); value.hasNext();) {
                SvnFileDataBean fileDetail = value.next();
                String string = fileDetail.getFilePath();
                String value1 = "";
                try {
                    value1 = string.substring(0, key.length());
                } catch (Exception e) {
                }                
                if (value1.equals(key)) {
                    try {
                        if (key.length() - 1 > 0) {
                            if (!string.substring(key.length() - 1).equals("/")) {
                                fileDetail.setFilePath(string.substring(key.length() - 1));
                                list.add(fileDetail);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("in exception catch::::::" + string);
                        break;
                    }
                } else {
                    if (!list.isEmpty()) {
                        Collections.sort(list);                                      
                        getFolderStructure(list, level + 1);
                    }

                    List<SvnFileDataBean> newList = new ArrayList<>();
                    for (int i = cnt; i < fileList.size(); i++) {

                        newList.add(fileList.get(i));
                    }
                    Collections.sort(newList);                                   
                    getFolderStructure(newList, level);
                    return;
                }
                cnt++;
            }

            level++;
            Collections.sort(list);            
            getFolderStructure(list, level);
        }
    }

    /**
     * @author ravi
     * generate list of FolderDataBean and sets it in dataList in dataList systemResultViewUtil
     */
    public void populateList() {

        Long id = systemResultSessionUtil.getSvnDetailId();
        List<SvnDataBean> svnDataById = new ArrayList<>();
        if (id != null) {
            svnDataById = svnTransformerBean.retrieveSvnDataById(id);
        }
        List<SvnFileDataBean> fileList = new ArrayList<>();
        for (SvnDataBean svnDataBean : svnDataById) {
            List<SvnFileDataBean> svnFileDataBeans = svnDataBean.getSvnFileDataBeans();
            for (SvnFileDataBean svnFileDataBean : svnFileDataBeans) {
                svnFileDataBean.setFilePath(svnFileDataBean.getFilePath() + "/");
                fileList.add(svnFileDataBean);
            }
        }
        Collections.sort(fileList);
        if (!fileList.isEmpty()) {
            getFolderStructure(fileList, 1);
        }
        if (!listData.isEmpty()) {
            systemResultViewUtil.setDataList(listData);
        }
    }
}
