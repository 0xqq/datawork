/*-
 * <<
 * task
 * ==
 * Copyright (C) 2019 - 2020 sia
 * ==
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * >>
 */

package top.dataworks.task.scheduler.job.triggers;//package top.dataworks.scheduler.quartz.trigger;
//
//import top.dataworks.base.util.Constant;
//import top.dataworks.core.helper.DateFormatHelper;
//import top.dataworks.mquartz.job.trigger.Trigger;
//import top.dataworks.mquartz.job.trigger.TriggerBuilder;
//import top.dataworks.mquartz.utils.DateBuilder;
//
//import java.text.ParseException;
//import java.util.Date;
//
///**
// * Calendar Interval
// * @author create by maozhengwei at 2019-03-05 10:51
// * @description:
// */
//public class CalendarIntervalTriggerImpl extends AbstractTrigger {
//
//
//    private int timeinterval;
//
//    private Date startTime;
//
//    private DateBuilder.IntervalUnit intervalUnit;
//
//    public CalendarIntervalTriggerImpl(int timeinterval, Date startTime, DateBuilder.IntervalUnit intervalUnit) {
//        this.timeinterval = timeinterval;
//        this.startTime = startTime;
//        this.intervalUnit = intervalUnit;
//    }
//
//    private Trigger triggerBuild(String jobName, String jobGroup) {
//        Trigger trigger;
//
//        CalendarIntervalTrigger calendarIntervalTrigger = TriggerBuilder.newTrigger()
//                .withIdentity(jobName, jobGroup)
//                .withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(timeinterval, intervalUnit))
//                .startAt(startTime)
//                .build();
//
//
//        return calendarIntervalTrigger;
//    }
//
//    private static Trigger buildTrigger(String jobKey, String jobGroup, String trigerValue) {
//        String[] triggerValues = trigerValue.split(Constant.REGEX_COMMA);
//        if (triggerValues.length == 0) {
//            throw new IndexOutOfBoundsException(Constant.LOG_PREFIX
//                    + "The trigger type of the current job is : CalendarInterval ,but trigerValue.split(,).length is zero");
//        }
//        Date startTime;
//        try {
//            startTime = DateFormatHelper.parse(triggerValues[0]);
//        } catch (ParseException e) {
//            throw new IllegalArgumentException("The time format must be : yyyy-MM-dd HH:mm:ss");
//        }
//        DateBuilder.IntervalUnit intervalUnit = DateBuilder.IntervalUnit.valueOf(triggerValues[1]);
//        int timeinterval = Integer.valueOf(triggerValues[2]);
//        return new CalendarIntervalTriggerImpl(timeinterval,startTime,intervalUnit).triggerBuild(jobKey,jobGroup);
//    }
//
//
//    /**
//     * @param jobKey
//     * @param jobGroup
//     * @param trigerType
//     * @param trigerValue
//     * @return
//     */
//    @Override
//    Trigger build(String jobKey, String jobGroup, String trigerType, String trigerValue) {
//        return buildTrigger(jobKey,jobGroup,trigerValue);
//    }
//}
