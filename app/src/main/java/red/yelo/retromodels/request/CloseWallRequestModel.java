/*
 *
 *  * Copyright (C) 2015 yelo.red
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */package red.yelo.retromodels.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anshul1235 on 29/10/14.
 */
public class CloseWallRequestModel {

    @SerializedName("login_id")
    public String user_id;

    @SerializedName("mobile_number")
    public String mobile_number;

    @SerializedName("name")
    public String name;

    @SerializedName("is_solved")
    public String is_solved;

    public void setIs_solved(String is_solved) {
        this.is_solved = is_solved;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
