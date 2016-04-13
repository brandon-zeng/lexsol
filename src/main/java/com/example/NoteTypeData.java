package com.example;

import com.example.model.tables.records.NotetypeRecord;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public Boolean getSecondarydate() {
        return secondarydate;
    }

    public void setSecondarydate(Boolean secondarydate) {
        this.secondarydate = secondarydate;
    }

    public int getSitevisit() {
        return siteVisit;
    }

    public void setSiteVisit(int siteVisit) {
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

    public JsonNode getDiscussionTopics() {
        return discussionTopics;
    }

    public void setDiscussionTopics(JsonNode discussionTopics) {
        this.discussionTopics = discussionTopics;
    }

    private int id;
    private String name;
    private Boolean secondarydate;
    private int siteVisit;
    private Boolean showDealIssues;
    private int deletePermittedInterval;
    private JsonNode discussionTopics;

    public static NoteTypeData from(NotetypeRecord record){
        try {
            ObjectMapper jackson = new ObjectMapper();

            NoteTypeData data = new NoteTypeData();
            data.setId(record.getId());
            data.setName(record.getName());
            data.setSecondarydate(record.getSecondarydate());
            data.setSiteVisit(record.getSitevisitId());
            data.setShowDealIssues(record.getShowdealissues());
            data.setDeletePermittedInterval(record.getDeletepermittedinterval());
            data.setDiscussionTopics(jackson.readTree(record.getDiscussiontopics()));

            return data;
        } catch (Exception e) {
            return new NoteTypeData();
        }
    }

    public static NoteTypeData from(int id){
        NoteTypeData data = new NoteTypeData();
        data.setId(id);

        return data;
    }
}
