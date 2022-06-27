package hien.t.appwidgetexercise

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import java.util.*


/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [RandomWidgetConfigureActivity]
 */

const val WIDGET_SYNC = "WIDGET_SYNC"

class RandomWidget : AppWidgetProvider() {

    lateinit var preference: MyPreference

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        if (!::preference.isInitialized) {
            preference = MyPreference(context)
        }

        val ids = preference.getWidgetIds()

        for (appWidgetId in appWidgetIds) {
            ids.add(appWidgetId.toString())
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
        preference.updateWidgetIds(ids)
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle?
    ) {
        updateAppWidget(context, appWidgetManager, appWidgetId)

        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
        for (appWidgetId in appWidgetIds) {
            RandomWidgetConfigureActivity.deleteTitlePref(context, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        val intent = Intent(context, RandomWidget::class.java)
        intent.action = WIDGET_SYNC
        val pendingIntent = PendingIntent.getBroadcast(context, 60000, intent, 0)
        val now = Calendar.getInstance()
        now.set(Calendar.SECOND, 0)
        now.add(Calendar.MINUTE, 1)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setInexactRepeating(AlarmManager.RTC, now.timeInMillis, 60000, pendingIntent)

    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }



    override fun onReceive(context: Context, intent: Intent?) {
        if (WIDGET_SYNC == intent?.action) {if (!::preference.isInitialized) {
            preference = MyPreference(context)
        }

            val ids = preference.getWidgetIds()

            for (id in ids) {
                updateAppWidget(context, AppWidgetManager.getInstance(context), id.toInt())
            }
        }
        super.onReceive(context, intent)
    }

    companion object {

        internal fun updateAppWidget(
            context: Context, appWidgetManager: AppWidgetManager,
            appWidgetId: Int
        ) {

            val intent = Intent(context, RandomWidget::class.java)
            intent.action = WIDGET_SYNC
            val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
            //val widgetText = RandomWidgetConfigureActivity.loadTitlePref(context, appWidgetId)
            // Construct the RemoteViews object
            val views = RemoteViews(context.packageName, R.layout.random_widget)
            views.setTextViewText(R.id.appwidget_text, Random().nextInt().toString())
            views.setOnClickPendingIntent(R.id.syncImageView,pendingIntent)

            // Instruct the widget manager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

