/*
 * Copyright (C) 2014 Trillian Mobile AB
 *
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
 */
package org.robovm.apple.foundation;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.security.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSDateComponents/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSDateComponentsPtr extends Ptr<NSDateComponents, NSDateComponentsPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSDateComponents.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSDateComponents() {}
    protected NSDateComponents(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "calendar")
    public native NSCalendar getCalendar();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "timeZone")
    public native NSTimeZone getTimeZone();
    @Method(selector = "era")
    public native @MachineSizedSInt long getEra();
    @Method(selector = "year")
    public native @MachineSizedSInt long getYear();
    @Method(selector = "month")
    public native @MachineSizedSInt long getMonth();
    @Method(selector = "day")
    public native @MachineSizedSInt long getDay();
    @Method(selector = "hour")
    public native @MachineSizedSInt long getHour();
    @Method(selector = "minute")
    public native @MachineSizedSInt long getMinute();
    @Method(selector = "second")
    public native @MachineSizedSInt long getSecond();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "nanosecond")
    public native @MachineSizedSInt long getNanosecond();
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 7.0.
     */
    @Deprecated
    @Method(selector = "week")
    public native @MachineSizedSInt long getWeek();
    @Method(selector = "weekday")
    public native @MachineSizedSInt long getWeekday();
    @Method(selector = "weekdayOrdinal")
    public native @MachineSizedSInt long getWeekdayOrdinal();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "quarter")
    public native @MachineSizedSInt long getQuarter();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "weekOfMonth")
    public native @MachineSizedSInt long getWeekOfMonth();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "weekOfYear")
    public native @MachineSizedSInt long getWeekOfYear();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "yearForWeekOfYear")
    public native @MachineSizedSInt long getYearForWeekOfYear();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "isLeapMonth")
    public native boolean isLeapMonth();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "setCalendar:")
    public native void setCalendar(NSCalendar cal);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "setTimeZone:")
    public native void setTimeZone(NSTimeZone tz);
    @Method(selector = "setEra:")
    public native void setEra(@MachineSizedSInt long v);
    @Method(selector = "setYear:")
    public native void setYear(@MachineSizedSInt long v);
    @Method(selector = "setMonth:")
    public native void setMonth(@MachineSizedSInt long v);
    @Method(selector = "setDay:")
    public native void setDay(@MachineSizedSInt long v);
    @Method(selector = "setHour:")
    public native void setHour(@MachineSizedSInt long v);
    @Method(selector = "setMinute:")
    public native void setMinute(@MachineSizedSInt long v);
    @Method(selector = "setSecond:")
    public native void setSecond(@MachineSizedSInt long v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setNanosecond:")
    public native void setNanosecond(@MachineSizedSInt long value);
    /**
     * @since Available in iOS 2.0 and later.
     * @deprecated Deprecated in iOS 7.0.
     */
    @Deprecated
    @Method(selector = "setWeek:")
    public native void setWeek(@MachineSizedSInt long v);
    @Method(selector = "setWeekday:")
    public native void setWeekday(@MachineSizedSInt long v);
    @Method(selector = "setWeekdayOrdinal:")
    public native void setWeekdayOrdinal(@MachineSizedSInt long v);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "setQuarter:")
    public native void setQuarter(@MachineSizedSInt long v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setWeekOfMonth:")
    public native void setWeekOfMonth(@MachineSizedSInt long w);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setWeekOfYear:")
    public native void setWeekOfYear(@MachineSizedSInt long w);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setYearForWeekOfYear:")
    public native void setYearForWeekOfYear(@MachineSizedSInt long y);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setLeapMonth:")
    public native void setLeapMonth(boolean lm);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "date")
    public native NSDate getDate();
    /*</methods>*/
}
