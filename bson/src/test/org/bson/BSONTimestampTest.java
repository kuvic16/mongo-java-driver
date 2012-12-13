/*
 * Copyright (c) 2008 - 2012 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bson;

import org.bson.types.BSONTimestamp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BSONTimestampTest {

    @Test
    public void testComparable() {

        final int currTime = (int) (System.currentTimeMillis() / 1000);

        final BSONTimestamp t1 = new BSONTimestamp(currTime, 1);
        BSONTimestamp t2 = new BSONTimestamp(currTime, 1);

        assertEquals(0, t1.compareTo(t2));

        t2 = new BSONTimestamp(currTime, 2);

        assertTrue(t1.compareTo(t2) < 0);
        assertTrue(t2.compareTo(t1) > 0);

        t2 = new BSONTimestamp(currTime + 1, 1);

        assertTrue(t1.compareTo(t2) < 0);
        assertTrue(t2.compareTo(t1) > 0);
    }
}