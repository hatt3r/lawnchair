package com.android.launcher3;

import android.content.ComponentName;
import android.content.Context;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utility class to filter out components from various lists
 */
public class AppFilter {

    private final Set<ComponentName> mFilteredComponents;

    public AppFilter(Context context) {
        mFilteredComponents = Arrays.stream(
                context.getResources().getStringArray(R.array.filtered_components))
                .map(ComponentName::unflattenFromString)
                .collect(Collectors.toSet());
    }

    public boolean shouldShowApp(ComponentName app) {
        return !mFilteredComponents.contains(app);
    }

    //this method just removes/filters whatsapp icon and label from app drawer straight //
    public boolean shouldShowWhatsapp(ComponentName app) {
       return !"com.whatsapp".equals(app.getPackageName());
    }

    //this method just remove/filters facebook icon and label from app drawer//
    public boolean shouldShowFacebook(ComponentName app)
    {
        return !"com.facebook.katana".equals(app.getPackageName());
    }
}
