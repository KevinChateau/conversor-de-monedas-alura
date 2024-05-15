package org.kcastillo.conversormonedas.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public record TasaCambiosRecord(Long time_last_update_unix, String base_code, TasaCambiosInd conversion_rates) {
}
