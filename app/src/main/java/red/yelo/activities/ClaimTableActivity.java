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
 */package red.yelo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import red.yelo.R;
import red.yelo.fragments.AbstractYeloFragment;
import red.yelo.fragments.ClaimsTableFragment;
import red.yelo.fragments.RewardsFragment;
import red.yelo.utils.AppConstants.FragmentTags;


/**
 * @author Anshul Kamboj
 *         <p/>
 *         Activity responsible for showing all the claims status
 */
public class ClaimTableActivity extends AbstractYeloActivity {

    public static final String TAG = "ClaimTableActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        if (savedInstanceState == null) {
            loadClaimsTableScreen(getIntent().getExtras());
        }
    }


    public void loadClaimsTableScreen(Bundle args) {
        loadFragment(R.id.frame_content, (AbstractYeloFragment)
                        Fragment.instantiate(this, ClaimsTableFragment.class.getName(), args),
                FragmentTags.CLAIMS_TABLE_FRAGMENT, false, null);
    }


    @Override
    protected Object getTaskTag() {
        return hashCode();
    }


}
