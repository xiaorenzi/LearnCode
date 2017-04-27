package cn.com.xiaorenzi.learncode;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.com.xiaorenzi.common.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private ExpandableListView mExpandableListView;
    private List<String> groups;
    private List<List<String>> childrens;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected int initContentLayout() {
        return R.layout.activity_main;
    }
    @Override
    protected void initView() {
        mExpandableListView = (ExpandableListView) findViewById(R.id.lv_expandable);
        mExpandableListView.setAdapter(new ExpadableAdapter());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                showToastLong("groupPosition=" + groupPosition + " childPosition=" + childPosition);
                return true;
            }
        });
    }

    protected void initData() {
        groups = new ArrayList<>();
        groups.add("自定义控件-动画篇");
        groups.add("自定义控件-绘图篇");
        childrens = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            List<String> child = new ArrayList<>();
            switch (i) {
                case 0:
                    childrens.add(child);
                    break;
                case 1:
                    child.add("基本几何图");
                    childrens.add(child);
                    break;
            }
        }
    }

    class ExpadableAdapter implements ExpandableListAdapter {

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getGroupCount() {
            return groups.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childrens.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childrens.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = getTextView(0);
            textView.setText(groups.get(groupPosition));
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = getTextView(36);
            textView.setText(childrens.get(groupPosition).get(childPosition));
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupExpanded(int groupPosition) {

        }

        @Override
        public void onGroupCollapsed(int groupPosition) {

        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return 0;
        }

        TextView getTextView(int paddingLeft) {
            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
            TextView textView = new TextView(MainActivity.this);
            textView.setLayoutParams(lp);
            textView.setGravity(Gravity.CENTER_VERTICAL);
            textView.setPadding(paddingLeft, 0, 0, 0);
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            return textView;
        }

    }
}
