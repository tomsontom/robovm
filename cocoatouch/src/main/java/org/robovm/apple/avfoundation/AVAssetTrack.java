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
package org.robovm.apple.avfoundation;

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
import org.robovm.apple.dispatch.*;
import org.robovm.apple.coreanimation.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.coreaudio.*;
import org.robovm.apple.coremedia.*;
import org.robovm.apple.corevideo.*;
import org.robovm.apple.audiotoolbox.*;
import org.robovm.apple.mediatoolbox.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVAssetTrack/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements AVAsynchronousKeyValueLoading/*</implements>*/ {

    /*<ptr>*/public static class AVAssetTrackPtr extends Ptr<AVAssetTrack, AVAssetTrackPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVAssetTrack.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVAssetTrack() {}
    protected AVAssetTrack(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "asset")
    public native AVAsset getAsset();
    @Property(selector = "trackID")
    public native int getTrackID();
    @Property(selector = "mediaType")
    public native String getMediaType();
    @Property(selector = "formatDescriptions")
    public native NSArray<?> getFormatDescriptions();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "isPlayable")
    public native boolean isPlayable();
    @Property(selector = "isEnabled")
    public native boolean isEnabled();
    @Property(selector = "isSelfContained")
    public native boolean isSelfContained();
    @Property(selector = "totalSampleDataLength")
    public native long getTotalSampleDataLength();
    @Property(selector = "timeRange")
    public native @ByVal CMTimeRange getTimeRange();
    @Property(selector = "naturalTimeScale")
    public native int getNaturalTimeScale();
    @Property(selector = "estimatedDataRate")
    public native float getEstimatedDataRate();
    @Property(selector = "languageCode")
    public native String getLanguageCode();
    @Property(selector = "extendedLanguageTag")
    public native String getExtendedLanguageTag();
    @Property(selector = "naturalSize")
    public native @ByVal CGSize getNaturalSize();
    @Property(selector = "preferredTransform")
    public native @ByVal CGAffineTransform getPreferredTransform();
    @Property(selector = "preferredVolume")
    public native float getPreferredVolume();
    @Property(selector = "nominalFrameRate")
    public native float getNominalFrameRate();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "minFrameDuration")
    public native @ByVal CMTime getMinFrameDuration();
    @Property(selector = "segments")
    public native NSArray<AVAssetTrackSegment> getSegments();
    @Property(selector = "commonMetadata")
    public native NSArray<AVMetadataItem> getCommonMetadata();
    @Property(selector = "availableMetadataFormats")
    public native NSArray<NSString> getAvailableMetadataFormats();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "availableTrackAssociationTypes")
    public native NSArray<NSString> getAvailableTrackAssociationTypes();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "hasMediaCharacteristic:")
    public native boolean hasMediaCharacteristic(String mediaCharacteristic);
    @Method(selector = "segmentForTrackTime:")
    public native AVAssetTrackSegment getSegment(@ByVal CMTime trackTime);
    @Method(selector = "samplePresentationTimeForTrackTime:")
    public native @ByVal CMTime getSamplePresentationTime(@ByVal CMTime trackTime);
    @Method(selector = "metadataForFormat:")
    public native NSArray<AVMetadataItem> getMetadata(String format);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "associatedTracksOfType:")
    public native NSArray<AVAssetTrack> getAssociatedTracks(String trackAssociationType);
    @Method(selector = "statusOfValueForKey:error:")
    public native AVKeyValueStatus getStatusOfValue(String key, NSError.NSErrorPtr outError);
    @Method(selector = "loadValuesAsynchronouslyForKeys:completionHandler:")
    public native void loadValuesAsynchronously(NSArray<NSString> keys, @Block Runnable handler);
    /*</methods>*/
}
