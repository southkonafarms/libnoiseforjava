#!/bin/bash
:> ~/Src/celestiaExperiment/celestia-g2/celestia/cosmos/cosmos.ssc
for vbl in $(ls -1 celestia/cosmos/*.ssc);do echo $vbl;  cat $vbl |sed -e 's=,==g' |tee -a ~/Src/celestiaExperiment/celestia-g2/celestia/cosmos/cosmos.ssc; done
