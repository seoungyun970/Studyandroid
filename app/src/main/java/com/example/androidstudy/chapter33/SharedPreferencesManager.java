package com.example.androidstudy.chapter33;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class SharedPreferencesManager {
    public static final String PREFERENCES_NAME = "rebuild_preference";
    private static final String DEFAULT_VALUE_STRING = null;
    private static final int DEFAULT_VALUE_INT = -1;
    private static boolean DEFAULT_VALUE_BOOLEAN = false;
    private static long DEFAULT_VALUE_LONG = -1L;
    private static float DEFAULT_VALUE_FLOAT = -1f;

    private static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    /**
     *String 값 저장
     * @param context
     * @param key
     * @param value
     * */
    public static void setString(Context context, String key, String value) {
        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(key, value);

        editor.apply();
//        editor.commit();
//        apply >>>> apply 를 사용하는게 속도 측면에서 빠름  대신 성공 또는 실패를 반환 x 비동기
//        commit >>> 속도 느림 대신 반환값 저장 동기

    }

    /**
     * boolean 값 저장
     *
     * @param context
     * @param key
     * @param value
     */

    public static void setBoolean(Context context, String key, boolean value) {

        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean(key, value);

        editor.commit();

    }

    /**

     * int 값 저장

     * @param context

     * @param key

     * @param value

     */

    public static void setInt(Context context, String key, int value) {

        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putInt(key, value);

        editor.apply();

    }

    /**

     * long 값 저장

     * @param context

     * @param key

     * @param value

     */

    public static void setLong(Context context, String key, int value) {

        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong(key, value);

        editor.apply();
    }

    /**

     * float 값 저장

     * @param context

     * @param key

     * @param value

     */

    public static void setFloat(Context context, String key, int value) {

        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putFloat(key, value);

        editor.apply();
    }

    /**
     * Array 값 저장
     * @param context
     * @param key
     * @param values
     * Arraylist 를 json으로 변환하여 String을 저장
     * */

    public static void setStringArray(Context context, String key, ArrayList<String> values) {

        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i <values.size(); i++) {
           jsonArray.put(values.get(i));
        }
        if (!values.isEmpty()) {
           editor.putString(key, jsonArray.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }

    /**

     * String 값 로드

     * @param context

     * @param key

     * @return

     */

    public static String getString(Context context,String key) {

        SharedPreferences prefs = getPreferences(context);

        String value = prefs.getString(key,DEFAULT_VALUE_STRING);

        return value;
    }

    /**

     * boolean 값 로드

     * @param context

     * @param key

     * @return

     */

    public static Boolean getBoolean(Context context,String key) {

        SharedPreferences prefs = getPreferences(context);

        Boolean value = prefs.getBoolean(key,DEFAULT_VALUE_BOOLEAN);

        return value;
    }

    /**

     * int 값 로드

     * @param context

     * @param key

     * @return

     */

    public static int getInt(Context context,String key) {

        SharedPreferences prefs = getPreferences(context);

        int value = prefs.getInt(key,DEFAULT_VALUE_INT);

        return value;
    }
    /**

     * long 값 로드

     * @param context

     * @param key

     * @return

     */

    public static Long getLong(Context context ,String key) {

        SharedPreferences prefs = getPreferences(context);

        Long value = prefs.getLong(key, DEFAULT_VALUE_LONG);

        return value;
    }

    /**

     * float 값 로드

     * @param context

     * @param key

     * @return

     */

    public static float getFloat(Context context, String key) {

        SharedPreferences prefs = getPreferences(context);

        Float value = prefs.getFloat(key,DEFAULT_VALUE_FLOAT);

        return value;
    }

    public static ArrayList<String> getStringArray(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);

        String json = prefs.getString(key,null);

        ArrayList<String> strings = new ArrayList<String>();

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0 ; i < jsonArray.length(); i++) {
                    String url = jsonArray.optString(i);
                    strings.add(url);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    /**

     * 키 값 삭제

     * @param context

     * @param key

     */
    public static void removeKey(Context context,String key) {

        SharedPreferences prefs = getPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();

        editor.remove(key);

        editor.apply();
    }

    /**

     * 모든 저장 데이터 삭제

     * @param context

     */

    public static void clear(Context context) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.apply();
    }
}
