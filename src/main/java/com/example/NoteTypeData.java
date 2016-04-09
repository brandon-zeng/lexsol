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

    public SiteData getSite() {
        return site;
    }

    public void setSite(SiteData site) {
        this.site = site;
    }

    public LocalDateTime getSecondarydate() {
        return secondarydate;
    }

    public void setSecondarydate(LocalDateTime secondarydate) {
        this.secondarydate = secondarydate;
    }

    public Boolean getSitevisitNote() {
        return sitevisitNote;
    }

    public void setSitevisitNote(Boolean sitevisitNote) {
        this.sitevisitNote = sitevisitNote;
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

    public ObjectNode getDiscussionTopics() {
        return discussionTopics;
    }

    public void setDiscussionTopics(ObjectNode discussionTopics) {
        this.discussionTopics = discussionTopics;
    }

    private int id;
    private String name;
    private SiteData site;
    private LocalDateTime secondarydate;
    private Boolean sitevisitNote;
    private Boolean showDealIssues;
    private int deletePermittedInterval;
    private ObjectNode discussionTopics;

    public static NoteTypeData from(NotetypeRecord record){
        NoteTypeData data = new NoteTypeData();
//        data.setId(record.getId());
//        data.setName(record.getName());
//        data.setSite(SiteData.from(record.getSiteId()));
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
