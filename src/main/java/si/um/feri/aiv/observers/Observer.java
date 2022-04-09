package si.um.feri.aiv.observers;

import si.um.feri.aiv.entity.Nakup;

public interface Observer {
    void observe(Nakup nakup, ObserverEventType observerEventType);
}
