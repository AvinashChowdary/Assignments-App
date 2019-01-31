package com.example.avinashravilla.assignments.model.assignment;


public class Assignment {

    private String grade_percentage;

    private Creator creator;

    private Attachments attachments;

    private String default_total;

    private String scheduled_message_id;

    private String description;

    private String created_at;

    private String message_id;

    private String turned_in_count;

    private String past_due;

    private String title;

    private String lock_after_due;

    private String url;

    private Recipients recipients;

    private String viewable_in_gradebook;

    private String reviewed;

    private String due_at;

    private String id;

    private String post_at;

    private String timeline_id;

    public String getGrade_percentage() {
        return grade_percentage;
    }

    public void setGrade_percentage(String grade_percentage) {
        this.grade_percentage = grade_percentage;
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


    public String getScheduled_message_id() {
        return scheduled_message_id;
    }

    public void setScheduled_message_id(String scheduled_message_id) {
        this.scheduled_message_id = scheduled_message_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getPast_due() {
        return past_due;
    }

    public void setPast_due(String past_due) {
        this.past_due = past_due;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLock_after_due() {
        return lock_after_due;
    }

    public void setLock_after_due(String lock_after_due) {
        this.lock_after_due = lock_after_due;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Recipients getRecipients() {
        return recipients;
    }

    public void setRecipients(Recipients recipients) {
        this.recipients = recipients;
    }

    public String getReviewed() {
        return reviewed;
    }

    public void setReviewed(String reviewed) {
        this.reviewed = reviewed;
    }

    public String getDue_at() {
        return due_at;
    }

    public void setDue_at(String due_at) {
        this.due_at = due_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTimeline_id() {
        return timeline_id;
    }

    public void setTimeline_id(String timeline_id) {
        this.timeline_id = timeline_id;
    }

    public String getDefault_total() {
        return default_total;
    }

    public void setDefault_total(String default_total) {
        this.default_total = default_total;
    }

    public String getTurned_in_count() {
        return turned_in_count;
    }

    public void setTurned_in_count(String turned_in_count) {
        this.turned_in_count = turned_in_count;
    }

    public String getViewable_in_gradebook() {
        return viewable_in_gradebook;
    }

    public void setViewable_in_gradebook(String viewable_in_gradebook) {
        this.viewable_in_gradebook = viewable_in_gradebook;
    }

    public String getPost_at() {
        return post_at;
    }

    public void setPost_at(String post_at) {
        this.post_at = post_at;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [grade_percentage = "+grade_percentage+", creator = "+creator+", attachments = "+attachments+", default_total = "+default_total+", scheduled_message_id = "+scheduled_message_id+", description = "+description+", created_at = "+created_at+", message_id = "+message_id+", turned_in_count = "+turned_in_count+", past_due = "+past_due+", title = "+title+", lock_after_due = "+lock_after_due+", url = "+url+", recipients = "+recipients+", viewable_in_gradebook = "+viewable_in_gradebook+", reviewed = "+reviewed+", due_at = "+due_at+", id = "+id+", post_at = "+post_at+", timeline_id = "+timeline_id+"]";
    }
}
