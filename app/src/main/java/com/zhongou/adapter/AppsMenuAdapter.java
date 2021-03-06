package com.zhongou.adapter;

/**
 * 应用 适配
 * Created by nick on 15/10/22.
 */

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhongou.R;
import com.zhongou.view.ConferenceListActivity;
import com.zhongou.view.ExaminationAcitivity;
import com.zhongou.view.FinancialListAcitivity;
import com.zhongou.view.MapAttendAcitivity;
import com.zhongou.view.NoticeListActivity;
import com.zhongou.view.NotificationListActivity;
import com.zhongou.view.PerformanceManagerActivity;
import com.zhongou.view.ProcureMainActivity;
import com.zhongou.view.ScheduleMainActivity;
import com.zhongou.view.VehicleReturnListActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppsMenuAdapter extends BaseAdapter {
    private List<HashMap<String, Object>> mList;// 定义一个list对象
    private Context mContext;// 上下文
    public static final int APP_PAGE_SIZE = 16;// 每一页装载数据的大小
    private PackageManager pm;// 定义一个PackageManager对象

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param list    所有APP的集合
     * @param page    当前页
     */

    public AppsMenuAdapter(Context context, List<HashMap<String, Object>> list, int page) {
        Log.d("SJY", "应用个数=" + list.size());
        mContext = context;
        pm = context.getPackageManager();
        mList = new ArrayList<HashMap<String, Object>>();
        // 根据当前页计算装载的应用，每页只装载16个
        int i = page * APP_PAGE_SIZE;// 当前页的其实位置
        int iEnd = i + APP_PAGE_SIZE;// 所有数据的结束位置
        while ((i < list.size()) && (i < iEnd)) {
            mList.add(list.get(i));
            i++;
        }
    }

    public int getCount() {
        return mList.size();
    }

    public Object getItem(int position) {
        return mList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_home_menu, parent, false);
        }
        final HashMap<String, Object> appInfo = mList.get(position);
        ImageView appicon = (ImageView) convertView.findViewById(R.id.menu_icon);
        final TextView appname = (TextView) convertView.findViewById(R.id.menu_name);
        appicon.setImageResource((Integer)appInfo.get("icon"));//图片展示
        appname.setText(appInfo.get("name").toString());//功能名称

        final View finalConvertView = convertView;
        convertView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0://审批
                        Intent intent = new Intent(mContext, ExaminationAcitivity.class);
                        mContext.startActivity(intent);
                        break;
                    case 1://业绩管理
                        Intent intent1 = new Intent(mContext, PerformanceManagerActivity.class);
                        mContext.startActivity(intent1);
                        break;
                    case 2://外出考勤
                        Intent intent2 = new Intent(mContext, MapAttendAcitivity.class);
                        mContext.startActivity(intent2);
                        break;
                    case 3://公告
                        Intent intent3 = new Intent(mContext, NoticeListActivity.class);
                        mContext.startActivity(intent3);
                        break;
                    case 4://通知
                        Intent intent4 = new Intent(mContext, NotificationListActivity.class);
                        mContext.startActivity(intent4);
                        break;
                    case 5://财务
                        Intent intent5 = new Intent(mContext, FinancialListAcitivity.class);
                        mContext.startActivity(intent5);
                        break;
                    case 6://日程
                        Intent intent6 = new Intent(mContext, ScheduleMainActivity.class);
                        mContext.startActivity(intent6);
                        break;
                    case 7://会议
                        Intent intent7 = new Intent(mContext, ConferenceListActivity.class);
                        mContext.startActivity(intent7);
                        break;
                    case 8://采购领用
                        Intent intent8 = new Intent(mContext, ProcureMainActivity.class);
                        mContext.startActivity(intent8);
                        break;
                    case 9://交车
                        Intent intent9 = new Intent(mContext, VehicleReturnListActivity.class);
                        mContext.startActivity(intent9);
                        break;
                }

            }
        });
        return convertView;
    }

}
