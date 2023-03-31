package com.empeople.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

        @SerializedName("id")
        private String id;
        @SerializedName("userID")
        private  String userID;
        @SerializedName("name")
        private  String name;
        private String referral_id;
        private String verify_status;
        private String profile;
        private String email;
        private String mobile;
        private String otp;
        private String father_name;
        private String password;
        private String dob;
        private String city;
        private String state;
        private String country;
        private String zip;
        private String address1;
        private String address2;
        private String landmark;
        private String alt_mobile;
        private String additional_info;
        private String userType;
        private String joiningtype;
        private String right_point;
        private String left_point;
        private String total_match_point;
        private String status;

        public joiningList getJoininglist() {
            return joininglist;
        }

        public void setJoininglist(joiningList joininglist) {
            this.joininglist = joininglist;
        }

        @SerializedName("joiningList")
        @Expose
        private joiningList joininglist;

        public userPoints getUserpoints() {
            return userpoints;
        }

        public void setUserpoints(userPoints userpoints) {
            this.userpoints = userpoints;
        }

        @SerializedName("userPoints")
        @Expose
        private userPoints userpoints;
        public String getAc_holder_name() {
            return ac_holder_name;
        }

        public void setAc_holder_name(String ac_holder_name) {
            this.ac_holder_name = ac_holder_name;
        }

        private String ac_holder_name;

        public String getAccount_no() {
            return account_no;
        }

        public void setAccount_no(String account_no) {
            this.account_no = account_no;
        }

        private String account_no;

        public String getIfsc_code() {
            return ifsc_code;
        }

        public void setIfsc_code(String ifsc_code) {
            this.ifsc_code = ifsc_code;
        }

        private String ifsc_code;

        public String getBank_master_id() {
            return bank_master_id;
        }

        public void setBank_master_id(String bank_master_id) {
            this.bank_master_id = bank_master_id;
        }

        private String bank_master_id;

        public String getPan_no() {
            return pan_no;
        }

        public void setPan_no(String pan_no) {
            this.pan_no = pan_no;
        }

        private String pan_no;


        public String getReferral_id() {
            return referral_id;
        }

        public void setReferral_id(String referral_id) {
            this.referral_id = referral_id;
        }

        public String getVerify_status() {
            return verify_status;
        }

        public void setVerify_status(String verify_status) {
            this.verify_status = verify_status;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }

        public String getFather_name() {
            return father_name;
        }

        public void setFather_name(String father_name) {
            this.father_name = father_name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public String getAlt_mobile() {
            return alt_mobile;
        }

        public void setAlt_mobile(String alt_mobile) {
            this.alt_mobile = alt_mobile;
        }

        public String getAdditional_info() {
            return additional_info;
        }

        public void setAdditional_info(String additional_info) {
            this.additional_info = additional_info;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getJoiningtype() {
            return joiningtype;
        }

        public void setJoiningtype(String joiningtype) {
            this.joiningtype = joiningtype;
        }

        public String getRight_point() {
            return right_point;
        }

        public void setRight_point(String right_point) {
            this.right_point = right_point;
        }

        public String getLeft_point() {
            return left_point;
        }

        public void setLeft_point(String left_point) {
            this.left_point = left_point;
        }

        public String getTotal_match_point() {
            return total_match_point;
        }

        public void setTotal_match_point(String total_match_point) {
            this.total_match_point = total_match_point;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getModify_date() {
            return modify_date;
        }

        public void setModify_date(String modify_date) {
            this.modify_date = modify_date;
        }

        public String getCreated_date() {
            return created_date;
        }

        public void setCreated_date(String created_date) {
            this.created_date = created_date;
        }

        public String getForgot_passwordTime() {
            return forgot_passwordTime;
        }

        public void setForgot_passwordTime(String forgot_passwordTime) {
            this.forgot_passwordTime = forgot_passwordTime;
        }

        private String modify_date;
        private String created_date;
        private String forgot_passwordTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


