/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package ognl.internal.entry;

public class DeclaredMethodCacheEntry extends MethodCacheEntry {

    MethodType type;

    public enum MethodType {
        STATIC, NON_STATIC
    }

    public DeclaredMethodCacheEntry(Class<?> targetClass) {
        super(targetClass);
    }

    public DeclaredMethodCacheEntry(Class<?> targetClass, MethodType type) {
        super(targetClass);
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeclaredMethodCacheEntry)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        DeclaredMethodCacheEntry that = (DeclaredMethodCacheEntry) o;

        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

}
