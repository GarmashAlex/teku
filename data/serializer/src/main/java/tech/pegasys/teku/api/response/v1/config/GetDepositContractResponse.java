/*
 * Copyright Consensys Software Inc., 2025
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.api.response.v1.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;

public class GetDepositContractResponse {
  public final DepositContract data;

  @JsonCreator
  public GetDepositContractResponse(@JsonProperty("data") final DepositContract data) {
    this.data = data;
  }

  public GetDepositContractResponse(final int depositChainId, final String depositContractAddress) {
    this.data = new DepositContract(UInt64.valueOf(depositChainId), depositContractAddress);
  }
}
