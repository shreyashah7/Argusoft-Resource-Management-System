/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

/**
 * for storing changed file details of a specific SVN revision
 * @author ravi
 */
public class SvnFileDataBean implements Comparable<SvnFileDataBean>{

    private String filePath;
    //added,deleted,modified
    private String changeType;
    //directory,file
    private String pathType;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    @Override
    public String toString() {
        return "filePath=" + filePath + " pathType=" + pathType + " changeType=" + changeType;
    }        

    @Override
    public int compareTo(SvnFileDataBean compareFileDetail) {
        String compareFilePath = ((SvnFileDataBean) compareFileDetail).getFilePath();
 
		//ascending order
		return this.filePath.compareTo(compareFilePath);     
    }

}
