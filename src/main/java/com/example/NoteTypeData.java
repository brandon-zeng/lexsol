package com.example;

import com.example.model.tables.records.NotetypeRecord;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDateTime;

/**
 * Created by vagrant on 4/8/16.
 */
public class NoteTypeData {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TenantData getTenant() {
        return tenant;
    }

    public void setTenant(TenantData tenant) {
        this.tenant = tenant;
    }

    public Boolean getSecondarydate() {
        return secondarydate;
    }

    public void setSecondarydate(Boolean secondarydate) {
        this.secondarydate = secondarydate;
    }

    public int getSitevisit() {
        return siteVisit;
    }

    public void setSitevisitNote(int siteVisit) {
        this.siteVisit = siteVisit;
    }

    public Boolean getShowDealIssues() {
        return showDealIssues;
    }

    public void setShowDealIssues(Boolean showDealIssues) {
        this.showDealIssues = showDealIssues;
    }

    public int getDeletePermittedInterval() {
        return deletePermittedInterval;
    }

    public void setDeletePermittedInterval(int deletePermittedInterval) {
        this.deletePermittedInterval = deletePermittedInterval;
    }

    public Object getDiscussionTopics() {
        return discussionTopics;
    }

    public void setDiscussionTopics(Object discussionTopics) {
        this.discussionTopics = discussionTopics;
    }

    private int id;
    private String name;
    private TenantData tenant;
    private Boolean secondarydate;
    private int siteVisit;
    private Boolean showDealIssues;
    private int deletePermittedInterval;
    private Object discussionTopics;

    public static NoteTypeData from(NotetypeRecord record){
        NoteTypeData data = new NoteTypeData();
//        data.setId(record.getId());
//        data.setName(record.getName());
//        data.setTenant(TenantData.from(record.getTenantId()));
//        data.setSecondarydate(record.getSecondarydate().toLocalTime());
//        data.setSitevisitNote(record.getSitevisitnote());
//        data.setShowDealIssues(record.getShowdealissues());
//        data.setDeletePermittedInterval(record.getDeletepermittedinterval());
//        data.setDiscussionTopics(new ObjectNode(record.getDiscussiontopics()));

        return data;
    }

    public static NoteTypeData from(int id){
        NoteTypeData data = new NoteTypeData();
        data.setId(id);

        return data;
    }
}
