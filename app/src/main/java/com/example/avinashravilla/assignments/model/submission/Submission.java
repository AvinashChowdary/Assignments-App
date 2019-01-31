package com.example.avinashravilla.assignments.model.submission;

public class Submission {

    private String assignment_id;

    private Creator creator;

    private Attachments attachments;

    private String submitted_at;

    private String num_replies;

    private String id;

    private String url;

    private String content;

    private String status;

    public String getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(String assignment_id) {
        this.assignment_id = assignment_id;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at(String submitted_at) {
        this.submitted_at = submitted_at;
    }

    public String getNum_replies() {
        return num_replies;
    }

    public void setNum_replies(String num_replies) {
        this.num_replies = num_replies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ClassPojo [assignment_id = " + assignment_id + ", creator = " + creator + ", attachments = " + attachments + ", submitted_at = " + submitted_at + ", num_replies = " + num_replies + ", id = " + id + ", url = " + url + ", content = " + content + ", status = " + status + "]";
    }
}