/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trino.plugin.tpch;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.trino.spi.connector.ColumnHandle;
import io.trino.spi.connector.ConnectorTableLayoutHandle;
import io.trino.spi.predicate.TupleDomain;

import java.util.Objects;

public class TpchTableLayoutHandle
        implements ConnectorTableLayoutHandle
{
    private final TpchTableHandle table;
    private final TupleDomain<ColumnHandle> predicate;

    @JsonCreator
    public TpchTableLayoutHandle(@JsonProperty("table") TpchTableHandle table, @JsonProperty("predicate") TupleDomain<ColumnHandle> predicate)
    {
        this.table = table;
        this.predicate = predicate;
    }

    @JsonProperty
    public TpchTableHandle getTable()
    {
        return table;
    }

    @JsonProperty
    public TupleDomain<ColumnHandle> getPredicate()
    {
        return predicate;
    }

    @Override
    public String toString()
    {
        return table.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TpchTableLayoutHandle that = (TpchTableLayoutHandle) o;
        return Objects.equals(table, that.table) &&
                Objects.equals(predicate, that.predicate);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(table, predicate);
    }
}
