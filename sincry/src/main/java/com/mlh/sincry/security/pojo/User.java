package com.mlh.sincry.security.pojo;

import java.util.Date;

public class User {

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.nickname
     *
     * @mbggenerated
     */
    private String nickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.pswd
     *
     * @mbggenerated
     */
    private String pswd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.last_login_time
     *
     * @mbggenerated
     */
    private Date lastLoginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_user.status
     *
     * @mbggenerated
     */
    private Long status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.id
     *
     * @return the value of u_user.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.id
     *
     * @param id the value for u_user.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.nickname
     *
     * @return the value of u_user.nickname
     *
     * @mbggenerated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.nickname
     *
     * @param nickname the value for u_user.nickname
     *
     * @mbggenerated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.email
     *
     * @return the value of u_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.email
     *
     * @param email the value for u_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.pswd
     *
     * @return the value of u_user.pswd
     *
     * @mbggenerated
     */
    public String getPswd() {
        return pswd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.pswd
     *
     * @param pswd the value for u_user.pswd
     *
     * @mbggenerated
     */
    public void setPswd(String pswd) {
        this.pswd = pswd == null ? null : pswd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.create_time
     *
     * @return the value of u_user.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.create_time
     *
     * @param createTime the value for u_user.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.last_login_time
     *
     * @return the value of u_user.last_login_time
     *
     * @mbggenerated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.last_login_time
     *
     * @param lastLoginTime the value for u_user.last_login_time
     *
     * @mbggenerated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_user.status
     *
     * @return the value of u_user.status
     *
     * @mbggenerated
     */
    public Long getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_user.status
     *
     * @param status the value for u_user.status
     *
     * @mbggenerated
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    public static enum EnumUserStatus{

        NORAML("0","正常"),
        FREEZE("1","冻结");

        private String code;
        private String name;

        private EnumUserStatus(String code,String name){
            this.code = code;
            this.name = name;
        }

        public String getNameByCode(String code){
            EnumUserStatus[] values = EnumUserStatus.values();
            for(EnumUserStatus status: values){
                if(status.getCode().equals(code)){
                    return status.getName();
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}