package org.example.application.port.out;

import org.example.application.domain.Impression;

import java.util.List;

public interface SaveImpressionsPort {

    void saveAllImpressions(List<Impression> impressions);
}
