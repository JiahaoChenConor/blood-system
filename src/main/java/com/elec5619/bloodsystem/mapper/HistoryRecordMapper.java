package com.elec5619.bloodsystem.mapper;

import com.elec5619.bloodsystem.domain.HistoryRecord;
import com.elec5619.bloodsystem.dto.HistoryRecordResponseDTO;

public class HistoryRecordMapper {
    public static HistoryRecordResponseDTO map(HistoryRecord historyRecord){
        return new HistoryRecordResponseDTO(historyRecord.getHistoryType(),
                historyRecord.getMeasure(),
                historyRecord.getBloodType(),
                historyRecord.getLocation(),
                historyRecord.getDate());
    }
}
