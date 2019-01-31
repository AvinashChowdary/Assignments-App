package com.example.avinashravilla.assignments.model.assignment;

public class Groups {
    private String parent_read_only;

    private String auto_add_main_group_members;

    private String group_listing;

    private String default_membership_type;

    private String parent_group_id;

    private String description;

    private String title;

    private String url;

    private String student_chat_status;

    private String archived;

    private String num_small_groups;

    private String master_read_only;

    private String group_user_type;

    private String num_members;

    private String parent_cannot_view_posts;

    private String id;

    public String getParent_read_only() {
        return parent_read_only;
    }

    public void setParent_read_only(String parent_read_only) {
        this.parent_read_only = parent_read_only;
    }

    public String getAuto_add_main_group_members() {
        return auto_add_main_group_members;
    }

    public void setAuto_add_main_group_members(String auto_add_main_group_members) {
        this.auto_add_main_group_members = auto_add_main_group_members;
    }

    public String getGroup_listing() {
        return group_listing;
    }

    public void setGroup_listing(String group_listing) {
        this.group_listing = group_listing;
    }

    public String getDefault_membership_type() {
        return default_membership_type;
    }

    public void setDefault_membership_type(String default_membership_type) {
        this.default_membership_type = default_membership_type;
    }

    public String getParent_group_id() {
        return parent_group_id;
    }

    public void setParent_group_id(String parent_group_id) {
        this.parent_group_id = parent_group_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStudent_chat_status() {
        return student_chat_status;
    }

    public void setStudent_chat_status(String student_chat_status) {
        this.student_chat_status = student_chat_status;
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public String getNum_small_groups() {
        return num_small_groups;
    }

    public void setNum_small_groups(String num_small_groups) {
        this.num_small_groups = num_small_groups;
    }

    public String getMaster_read_only() {
        return master_read_only;
    }

    public void setMaster_read_only(String master_read_only) {
        this.master_read_only = master_read_only;
    }

    public String getGroup_user_type() {
        return group_user_type;
    }

    public void setGroup_user_type(String group_user_type) {
        this.group_user_type = group_user_type;
    }

    public String getNum_members() {
        return num_members;
    }

    public void setNum_members(String num_members) {
        this.num_members = num_members;
    }

    public String getParent_cannot_view_posts() {
        return parent_cannot_view_posts;
    }

    public void setParent_cannot_view_posts(String parent_cannot_view_posts) {
        this.parent_cannot_view_posts = parent_cannot_view_posts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClassPojo [parent_read_only = " + parent_read_only + ", auto_add_main_group_members = " + auto_add_main_group_members + ", group_listing = " + group_listing + ", default_membership_type = " + default_membership_type + ", parent_group_id = " + parent_group_id + ", description = " + description + ", title = " + title + ", url = " + url + ", student_chat_status = " + student_chat_status + ", archived = " + archived + ", num_small_groups = " + num_small_groups + ", master_read_only = " + master_read_only + ", group_user_type = " + group_user_type + ", num_members = " + num_members + ", parent_cannot_view_posts = " + parent_cannot_view_posts + ", id = " + id + "]";
    }
}