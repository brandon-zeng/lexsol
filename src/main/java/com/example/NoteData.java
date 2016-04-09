package com.example;

import com.example.model.tables.records.NoteRecord;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDateTime;

/**
 * Created by vagrant on 4/8/16.
 */
public class NoteData {
    private int id;

    public SiteData getSite() {
        return site;
    }

    public void setSite(SiteData site) {
        this.site = site;
    }

    public NoteTypeData getNoteTypeData() {
        return noteTypeData;
    }

    public void setNoteTypeData(NoteTypeData noteTypeData) {
        this.noteTypeData = noteTypeData;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getSiteVisitId() {
        return siteVisitId;
    }

    public void setSiteVisitId(int siteVisitId) {
        this.siteVisitId = siteVisitId;
    }

    public LocalDateTime getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDateTime noteDate) {
        this.noteDate = noteDate;
    }

    public LocalDateTime getSecondaryDate() {
        return secondaryDate;
    }

    public void setSecondaryDate(LocalDateTime secondaryDate) {
        this.secondaryDate = secondaryDate;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public int getSecondaryDateChangedById() {
        return secondaryDateChangedById;
    }

    public void setSecondaryDateChangedById(int secondaryDateChangedById) {
        this.secondaryDateChangedById = secondaryDateChangedById;
    }

    public LocalDateTime getSecondaryDateChangeDate() {
        return secondaryDateChangeDate;
    }

    public void setSecondaryDateChangeDate(LocalDateTime secondaryDateChangeDate) {
        this.secondaryDateChangeDate = secondaryDateChangeDate;
    }

    public ObjectNode getDealIssues() {
        return dealIssues;
    }

    public void setDealIssues(ObjectNode dealIssues) {
        this.dealIssues = dealIssues;
    }

    public ObjectNode getDiscussionPoints() {
        return discussionPoints;
    }

    public void setDiscussionPoints(ObjectNode discussionPoints) {
        this.discussionPoints = discussionPoints;
    }

    private SiteData site;
    private NoteTypeData noteTypeData;
    private int propertyId;
    private int siteVisitId;
    private LocalDateTime noteDate;
    private LocalDateTime secondaryDate;
    private String noteText;
    private LocalDateTime createDate;
    private int createdById;
    private LocalDateTime lastModifiedDate;
    private int secondaryDateChangedById;
    private LocalDateTime secondaryDateChangeDate;
    private ObjectNode dealIssues;
    private ObjectNode discussionPoints;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static NoteData from(NoteRecord record){
        NoteData data = new NoteData();
//        data.setId(record.getId());
//        data.setSite(SiteData.from(record.getSiteId()));
//        data.setNoteTypeData(NoteTypeData.from(record.getNotetypeId()));
//        data.setSecondaryDate(record.getSecondarydate());
//        data.setNoteText(record.getNotetext());
//        data.setCreateDate(record.getCreateddate());
//        data.setCreatedById(record.getCreatedbyId());
//        data.setLastModifiedDate(record.getLastmodifieddate());
//        data.setSecondaryDateChangedById(record.getSecondarydatechangedbyId());
//        data.setSecondaryDateChangeDate(record.getSecondarydatechangedate());
//        data.setDealIssues(record.getDealissues());
//        data.setDiscussionPoints(record.getDiscussionpoints());

        return data;
    }
}
