
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
 */package red.yelo.widgets.autocomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

import red.yelo.R;
import red.yelo.retromodels.response.KeywordSuggestionsResponseModel;


/**
 * Adapter for suggestions
 *
 */
public class SuggestionsAdapter extends BaseAdapter implements Filterable {

    private Context                mContext;

    /**
     * The master list of suggestions from which other suggestions are fetched
     */
    private List<KeywordSuggestionsResponseModel.Keywords>       mSuggestionsMaster;

    /**
     * The list of suggestions that are actually displayed
     */
    private List<KeywordSuggestionsResponseModel.Keywords>       mVisibleSuggestions;

    /**
     * The filter for this adapter
     */
    private final SuggestionFilter mSuggestionsFilter;

    /**
     * Used to determine whether suggestions should be displayed or not
     */
    private boolean                mDisplaySuggestions;

    /**
     * Construct a suggestions adapter with an initial data set
     *
     * @param context
     * @param suggestions The initial master set of {@link Suggestion} objects
     */
    public SuggestionsAdapter(Context context, final List<KeywordSuggestionsResponseModel.Keywords> suggestions) {

        mContext = context;
        mSuggestionsMaster = suggestions;
        mSuggestionsFilter = new SuggestionFilter(this);
        mDisplaySuggestions = true;
    }

    /**
     * Enable/Disable suggestions
     */
    public void setDisplaySuggestionsEnabled(boolean enabled) {
        mDisplaySuggestions = enabled;
    }

    @Override
    public int getCount() {

        if (mDisplaySuggestions) {
            return mVisibleSuggestions == null ? 0 : mVisibleSuggestions.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(final int position) {
        return mVisibleSuggestions.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView,
                    final ViewGroup parent) {

        View view = convertView;

        if (view == null) {

            view = LayoutInflater
                            .from(parent.getContext())
                            .inflate(R.layout.layout_user_suggestion_item, parent, false);
            view.setTag(R.id.text_suggestion, view
                            .findViewById(R.id.text_suggestion));
        }

        KeywordSuggestionsResponseModel.Keywords suggestion = mVisibleSuggestions.get(position);
        ((TextView) view.getTag(R.id.text_suggestion)).setText(suggestion.name);


        return view;
    }

    @Override
    public Filter getFilter() {
        return mSuggestionsFilter;
    }

    /**
     * Gets the master list of suggestions contained in this adapter
     */
    public List<KeywordSuggestionsResponseModel.Keywords> getSuggestionsMaster() {
        return mSuggestionsMaster;
    }

    /**
     * Swaps the list of suggestions
     *
     * @param suggestions The list of suggestions
     */
    public void setSuggestions(final List<KeywordSuggestionsResponseModel.Keywords> suggestions) {
        mVisibleSuggestions = suggestions;
        notifyDataSetChanged();
    }

    /**
     * Swaps the list of master suggestions
     *
     * @param suggestions The list of suggestions
     */
    public void setSuggestionsMaster(final List<KeywordSuggestionsResponseModel.Keywords> suggestions) {
        mDisplaySuggestions = true;
        mSuggestionsMaster = suggestions;
        mVisibleSuggestions = null;
        notifyDataSetChanged();
    }

}
