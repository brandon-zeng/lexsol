package com.example;


import com.example.model.tables.records.NoteRecord;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Created by vagrant on 4/8/16.
 */
public class NoteData {
    private int id;

    public TenantData getTenant() {
        return tenant;
    }

    public void setTenant(TenantData tenant) {
        this.tenant = tenant;
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

    public JsonNode getDealIssues() {
        return dealIssues;
    }

    public void setDealIssues(JsonNode dealIssues) {
        this.dealIssues = dealIssues;
    }

    public JsonNode getDiscussionPoints() {
        return discussionPoints;
    }

    public void setDiscussionPoints(JsonNode discussionPoints) {
        this.discussionPoints = discussionPoints;
    }

    private TenantData tenant;
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
    private JsonNode dealIssues;
    private JsonNode discussionPoints;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static NoteData from(NoteRecord record){
        try {
            NoteData data = new NoteData();
            ObjectMapper jackson = new ObjectMapper();

            data.setId(record.getId());
            data.setTenant(TenantData.from(record.getTenantId()));
            data.setNoteTypeData(NoteTypeData.from(record.getNotetypeId()));
            data.setSecondaryDate(record.getSecondarydate().toLocalDateTime());
            data.setNoteText(record.getNote());
            data.setCreateDate(record.getCreateddate().toLocalDateTime());
            data.setCreatedById(record.getCreatedby());
            data.setLastModifiedDate(record.getLastmodifieddate().toLocalDateTime());
            data.setSecondaryDateChangedById(record.getSecondarydatechangedbyId());
            if (record.getSecondarydatechangedate() != null) {
                data.setSecondaryDateChangeDate(record.getSecondarydatechangedate().toLocalDateTime());
            }
            data.setDealIssues(jackson.readTree(record.getDealissues()));
            data.setDiscussionPoints(jackson.readTree(record.getDiscussionpoints()));

            return data;
        } catch (Exception e) {
            return new NoteData();
        }

    }
}
