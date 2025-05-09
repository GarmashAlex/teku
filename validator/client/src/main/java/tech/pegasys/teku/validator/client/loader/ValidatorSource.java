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

package tech.pegasys.teku.validator.client.loader;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import tech.pegasys.teku.bls.BLSPublicKey;
import tech.pegasys.teku.bls.keystore.model.KeyStoreData;
import tech.pegasys.teku.spec.signatures.Signer;
import tech.pegasys.teku.validator.client.restapi.apis.schema.DeleteKeyResult;

public interface ValidatorSource {
  List<? extends ValidatorProvider> getAvailableValidators();

  boolean canUpdateValidators();

  DeleteKeyResult deleteValidator(BLSPublicKey publicKey);

  AddValidatorResult addValidator(
      KeyStoreData keyStoreData, String password, BLSPublicKey publicKey);

  AddValidatorResult addValidator(final BLSPublicKey publicKey, Optional<URL> signerUrl);

  interface ValidatorProvider {
    BLSPublicKey getPublicKey();

    Signer createSigner();

    boolean isReadOnly();
  }
}
