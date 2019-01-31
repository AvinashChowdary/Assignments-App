package com.example.avinashravilla.assignments.model.assignment;

public class Creator {
    private String utc_offset;

    private String role;

    private String coppa_verified;

    private String last_name;

    private String type;

    private String time_zone;

    private String locale;

    private String vanity;

    private String url;

    private String verified_institution_member;

    private String user_title;

    private String id;

    private String first_name;

    private String country_id;

    private String username;

    private Avatars avatars;

    public String getUtc_offset() {
        return utc_offset;
    }

    public void setUtc_offset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCoppa_verified() {
        return coppa_verified;
    }

    public void setCoppa_verified(String coppa_verified) {
        this.coppa_verified = coppa_verified;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getVanity() {
        return vanity;
    }

    public void setVanity(String vanity) {
        this.vanity = vanity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVerified_institution_member() {
        return verified_institution_member;
    }

    public void setVerified_institution_member(String verified_institution_member) {
        this.verified_institution_member = verified_institution_member;
    }

    public String getUser_title() {
        return user_title;
    }

    public void setUser_title(String user_title) {
        this.user_title = user_title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Avatars getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }

    @Override
    public String toString() {
        return "ClassPojo [utc_offset = " + utc_offset + ", role = " + role + ", coppa_verified = " + coppa_verified + ", last_name = " + last_name + ", type = " + type + ", time_zone = " + time_zone + ", locale = " + locale + ", vanity = " + vanity + ", url = " + url + ", verified_institution_member = " + verified_institution_member + ", user_title = " + user_title + ", id = " + id + ", first_name = " + first_name + ", country_id = " + country_id + ", username = " + username + ", avatars = " + avatars + "]";
    }
}