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
package org.robovm.apple.audiotoolbox;

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
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.opengles.*;
import org.robovm.apple.coreaudio.*;
import org.robovm.apple.coremedia.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAFOverviewChunk/*</name>*/ 
    extends /*<extends>*/Struct<CAFOverviewChunk>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAFOverviewChunkPtr extends Ptr<CAFOverviewChunk, CAFOverviewChunkPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CAFOverviewChunk() {}
    public CAFOverviewChunk(int mEditCount, int mNumFramesPerOVWSample, CAFOverviewSample mData) {
        this.mEditCount(mEditCount);
        this.mNumFramesPerOVWSample(mNumFramesPerOVWSample);
        this.mData(mData);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native int mEditCount();
    @StructMember(0) public native CAFOverviewChunk mEditCount(int mEditCount);
    @StructMember(1) public native int mNumFramesPerOVWSample();
    @StructMember(1) public native CAFOverviewChunk mNumFramesPerOVWSample(int mNumFramesPerOVWSample);
    @StructMember(2) public native @Array({1}) CAFOverviewSample mData();
    @StructMember(2) public native CAFOverviewChunk mData(@Array({1}) CAFOverviewSample mData);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
