package com.empeople.Utils;

import com.empeople.Data.FaqData;
import com.empeople.Data.GalleryListResponse;
import com.empeople.Data.secureLoginResponse;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface AllAPIs {
    @GET("/api/mlm/User/referralList")
    Call<GalleryListResponse> getreferralList(@Header("x-api-key") String authorization);
    @GET("/api/mlm/User/getCountry")
    Call<GalleryListResponse> getCountry(@Header("x-api-key") String authorization);

    @GET("/api/mlm/User/getBankList")
    Call<GalleryListResponse> getBank(@Header("x-api-key") String authorization);

    @FormUrlEncoded
    @POST("/api/mlm/User/getState")
    Call<GalleryListResponse> getState(@Header("x-api-key") String authorization,
                                       @Field("country_id") String country_id
    );
    @FormUrlEncoded
    @POST("/api/mlm/User/getCity")
    Call<GalleryListResponse> getCity(@Header("x-api-key") String authorization,
                                      @Field("state_id") String state_id
    );
    @FormUrlEncoded
    @POST("/api/mlm/User/pickReferral")
    Call<secureLoginResponse> getpickReferral(@Header("x-api-key") String authorization,
                                              @Field("referral_id") String referralId

    );
    @Multipart
    @POST("/api/mlm/User/uploadDp")
    Call<secureLoginResponse> getUploadPic(@Header("x-api-key") String authorization,
                                           @Part("tbl_users_id") RequestBody userId,
                                           @Part MultipartBody.Part file5

    );
    @FormUrlEncoded
    @POST("/api/mlm/User/sigUp")
    Call<secureLoginResponse> createAccount(@Header("x-api-key") String authorization,
                                            @Field("referral_id") String referralId,
                                            @Field("password") String password,
                                            @Field("userID") String userId,
                                            @Field("confirm_password") String cpassword,
                                            @Field("email") String email,
                                            @Field("position") String position
    );
    @FormUrlEncoded
    @POST("/api/mlm/User/changePassword")
    Call<secureLoginResponse> changePassword(@Header("x-api-key") String authorization,
                                             @Field("id") String userId,
                                             @Field("oldPassword") String oldPassword,
                                             @Field("newPassword") String newPassword,
                                             @Field("confirmPassword") String confirmPassword
    );
    @FormUrlEncoded
    @POST("/api/mlm/User/userPersonalDetail")
    Call<secureLoginResponse> updatepersonalInfo(@Header("x-api-key") String authorization,
                                                 @Field("tbl_users_id") String id,
                                                 @Field("name") String name,
                                                 @Field("fname") String fathername,
                                                 @Field("dob") String dob,
                                                 @Field("email") String email,
                                                 @Field("mobile") String mobile

    );
    @FormUrlEncoded
    @POST("/api/mlm/User/userAccountDetails")
    Call<secureLoginResponse> updatebankInfo(@Header("x-api-key") String authorization,
                                             @Field("tbl_users_id") String id,
                                             @Field("pan_no") String panNo,
                                             @Field("bank_master_id") String bankid,
                                             @Field("ifsc_code") String ifsc,
                                             @Field("account_no") String accountNo,
                                             @Field("ac_holder_name") String acHolderName

    );
    @FormUrlEncoded
    @POST("/api/mlm/User/userContactDetails")
    Call<secureLoginResponse> updateuserContactDetails(@Header("x-api-key") String authorization,
                                                       @Field("tbl_users_id") String id,
                                                       @Field("house_no") String houseNo,
                                                       @Field("address") String address,
                                                       @Field("zip") String pin,
                                                       @Field("country") String country,
                                                       @Field("state") String state,
                                                       @Field("city") String city
    );
    @FormUrlEncoded
    @POST("/api/mlm/User/sinIn")
    Call<secureLoginResponse> signIn(@Header("x-api-key") String authorization,
                                     @Field("userID") String userId,
                                     @Field("password") String password,
                                     @Field("device_id") String device_id,
                                     @Field("fcm_id") String fcm_id
    );
    @FormUrlEncoded
    @POST("/api/mlm/User/forgotPassword")
    Call<secureLoginResponse> forgotPassword(@Header("x-api-key") String authorization,
                                             @Field("userID") String userId,
                                             @Field("email") String email

    );
    @FormUrlEncoded
    @POST("/api/mlm/User/forgotPassword")
    Call<secureLoginResponse> EmailLogin(@Header("x-api-key") String authorization,
                                         @Field("email") String email,
                                         @Field("userID") String userID
    );


    @FormUrlEncoded
    @POST("/api/mlm/User/signOut")
    Call<secureLoginResponse> SignOut(@Header("x-api-key") String authorization,
                                      @Field("id") String userId


    );
    @GET("/api/mlm/User/getMyRefferList")
    Call<GalleryListResponse> getrefferralList(@Header("x-api-key") String authorization,
                                               @Query("tbl_users_id") String userid
    );
    @GET("/api/mlm/User/getUserDetailLog")
    Call<secureLoginResponse> getUserDetailLog(@Header("x-api-key") String authorization,
                                               @Query("tbl_users_id") String userid
    );
    @GET("api/mlm/User/getFaq")
    Call<FaqData> getFaq(@Header("x-api_key") String authorization);


}




