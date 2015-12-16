# Birthday Reminder 2.0
App for Android devices which notifies users of upcoming birthdays.

![](http://julianrosser.website/images/app_screenshots/birthday15.png)![](http://julianrosser.website/images/app_screenshots/birthday16.png)

TODO
- Setting for Time of notification.
- FloatingActionButton
- Reminder on??? bool needed? NO
- if AlarmNOT SET, alert user
- Call service when Activity is stopped, save data when we add, edit or delete! (Delay service so Data is ALWAYS saved first)
- If settings changed, reset ALL alarms
- Tablet Layouts

- Deep linking
- Old APIs button highlight
- Analytics
- TypeFace-Light for api < 16
- 2 birthdays on same day?
- App launcher icon name
- Icon, screenshots, video

Next Update?
- Widget
- Custom Notification
- Animation
- SQL database instead of JSON ??? necessary? Will take effort, perhaps as backup

Bugs:
- Quickly click to open Fragments twice
- End of month bug?

Log
- 16/12 - Built custom Adapter so ItemOptionFrag shows Icons. Save/recall Fragment references onRotate.
          DialogFragment custom theme & size. Replaced unnecessary Activity context refs with AppContext. Refactored Arrays.
- 15/12 - Created NotificationBuilder class and added personalised notifications. Cake app icon. Vibrate pattern.
        - SettingActivity & Fragment. Works with days before remind setting. Reduced DatePicker padding.
- 14/12 - Auto sorting. Refactored LoadBirthdaysTask.
- 12/12 - Service is launched on boot. Created BootNotificationReceiver and SetAlarmService.
- 10/12 - Prevented context leaks. Built date/day remaining helper methods. RobotoLight font.
Custom date bg drawables with elevation. Now editing birthday instead of replacing. Updated screenshots.
- 09/12 - Saving/loading using lifecycle methods. New ItemMenuFragment to replace context hack. Rewrote BirthdayListView
          to Material-specs. Formatted and documented Adapter & Fragment.
- 08/12 - Added JSON save/load functions.
- 07/12 - Orientation change functionality. Adapter updates list correctly using UI Thread. Context menu (del, edit). Formatting & Documentation
- 06/12 - Add birthday (or edit) DialogFragment, layout & functionality. Fragment callback listener. Icon for menu_add.
- 04/12 - First real progress to redesign. Re-wrote Birthdays class, RecyclerView & Adapter now working correctly.
- 03/12 - Birthday list (RecyclerViewFragment) displays correctly. Rewrote Birthdays.java.
- 20/11 - Created RecyclerViewAdapter, converted to use Array of Birthdays. P
- 18/10 - Designed new UX on paper.
- 03/09 - Redesigned, formatted and documented Birthdays.java.
- 02/09/2015 - Built new AS project. Pushed to new GitHub repo.

