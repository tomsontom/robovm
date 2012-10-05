/*
 * Copyright (C) 2012 RoboVM
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
package org.robovm.cocoatouch.uikit;

import java.util.*;

public enum UIViewAnimationCurve {
    EaseInOut(0),
    EaseIn(1),
    EaseOut(2),
    Linear(3);

    private final int n;

    private UIViewAnimationCurve(int n) { this.n = n; }
    public int value() { return n; }
    public static UIViewAnimationCurve fromValue(int n) {
        for (UIViewAnimationCurve v : values()) {
            if (n == v.value()) {
                return v;
            }
        }
        throw new IllegalArgumentException("Unknown UIViewAnimationCurve value: " + n);
    }
}