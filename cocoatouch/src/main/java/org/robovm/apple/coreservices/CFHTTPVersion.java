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
package org.robovm.apple.coreservices;

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
import org.robovm.apple.foundation.*;
import org.robovm.apple.corefoundation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CFNetwork")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFHTTPVersion/*</name>*/ 
    extends /*<extends>*/Object/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(CFHTTPVersion.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFHTTPVersion Version1_0 = new CFHTTPVersion() {
        public CFString value() {
            return Version1_0Value();
        }
    };
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFHTTPVersion Version1_1 = new CFHTTPVersion() {
        public CFString value() {
            return Version1_1Value();
        }
    };
    private static CFHTTPVersion[] values = new CFHTTPVersion[] {Version1_0, Version1_1};
    
    private CFHTTPVersion() {
    }
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public CFString value() {
        return null;
    }
    
    public static CFHTTPVersion valueOf(CFString value) {
        if (value == null) throw new NullPointerException("value");
        for (CFHTTPVersion v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/CFHTTPVersion/*</name>*/.class.getName());
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalValue(symbol="kCFHTTPVersion1_0", optional=true)
    protected static native CFString Version1_0Value();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @GlobalValue(symbol="kCFHTTPVersion1_1", optional=true)
    protected static native CFString Version1_1Value();
    /*</methods>*/
}
