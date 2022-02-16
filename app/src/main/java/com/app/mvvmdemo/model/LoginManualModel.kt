package com.app.mvvmdemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginManualModel {
    var success_data: Success_data? = null
    var status: String? = null
    var success_message: String? = null
    var is_approved: Boolean? = null
    var screen_name: String? = null
    override fun toString(): String {
        return "ClassPojo [success_data = $success_data, status = $status]"
    }

    inner class Success_data {
        var customer_data: Customer_data? = null
        var provider_data: Provider_data? = null
        override fun toString(): String {
            return "ClassPojo [customer_data = $customer_data, provider_data = $provider_data]"
        }

        inner class Customer_data {
            var firstname: String? = null
            var city: String? = null
            var login_type: String? = null
            var cover_pic: String? = null
            var description: String? = null
            var created_at: String? = null
            var platform: String? = null
            var stripe_customer_id: String? = null
            var user_type: String? = null
            var is_deleted: String? = null
            var updated_at: String? = null
            var company: String? = null
            var is_notification: String? = null
            var id: String? = null
            var state: String? = null
            var remember_token: String? = null
            var email: String? = null
            var lat: String? = null
            var address: String? = null
            var lng: String? = null
            var auth_id: String? = null
            var current_role_id: String? = null
            var profile_pic: String? = null
            var deleted_at: String? = null
            var lastname: String? = null
            var zipcode: String? = null
            var country_code: String? = null
            var is_customer_data: String? = null
            var phone: String? = null
            var device_token: String? = null
            var username: String? = null
            var referal_code: String? = null
            var quickblox_id: String? = null
            var is_first_time_login: String? = null
            override fun toString(): String {
                return "ClassPojo [firstname = $firstname, city = $city, login_type = $login_type, cover_pic = $cover_pic, description = $description, created_at = $created_at, platform = $platform, stripe_customer_id = $stripe_customer_id, user_type = $user_type, is_deleted = $is_deleted, updated_at = $updated_at, company = $company, is_notification = $is_notification, id = $id, state = $state, remember_token = $remember_token, email = $email, lat = $lat, address = $address, lng = $lng, auth_id = $auth_id, current_role_id = $current_role_id, profile_pic = $profile_pic, deleted_at = $deleted_at, lastname = $lastname, zipcode = $zipcode, country_code = $country_code, is_customer_data = $is_customer_data, phone = $phone, device_token = $device_token, username = $username]"
            }
        }

        inner class Provider_data {
            @Expose
            @SerializedName("deleted_at")
            var deleted_at: String? = null

            @Expose
            @SerializedName("updated_at")
            var updated_at: String? = null

            @Expose
            @SerializedName("created_at")
            var created_at: String? = null

            @Expose
            @SerializedName("how_long_willing_to_travel")
            var how_long_willing_to_travel: String? = null

            @Expose
            @SerializedName("insurance")
            var insurance: String? = null

            @Expose
            @SerializedName("driver_license")
            var driver_license: String? = null

            @Expose
            @SerializedName("business_license")
            var business_license: String? = null

            @Expose
            @SerializedName("business_logo")
            var business_logo: String? = null

            @Expose
            @SerializedName("ein")
            var ein: String? = null

            @Expose
            @SerializedName("keywords_for_business")
            var keywords_for_business: String? = null

            @Expose
            @SerializedName("description")
            var description: String? = null

            @Expose
            @SerializedName("lng")
            var lng: String? = null

            @Expose
            @SerializedName("lat")
            var lat: String? = null

            @Expose
            @SerializedName("zipcode")
            var zipcode: String? = null

            @Expose
            @SerializedName("state")
            var state: String? = null

            @Expose
            @SerializedName("city")
            var city: String? = null

            @Expose
            @SerializedName("address")
            var address: String? = null

            @Expose
            @SerializedName("email")
            var email: String? = null

            @Expose
            @SerializedName("phone")
            var phone: String? = null

            @Expose
            @SerializedName("country_code")
            var country_code: String? = null

            @Expose
            @SerializedName("business_name")
            var business_name: String? = null

            @Expose
            @SerializedName("user_id")
            var user_id: String? = null

            @Expose
            @SerializedName("id")
            var id: String? = null

            @Expose
            @SerializedName("status")
            var status: String? = null
            var is_deleted: String? = null
            var is_suspended: String? = null
            var is_first_time_provider: String? = null
        }
    }
}