package org.example.application.port.out;

import org.example.application.domain.Click;

import java.util.List;

public interface SaveClicksPort {

    void saveAllClicks(List<Click> clicks);
}
