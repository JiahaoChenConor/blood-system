package com.elec5619.bloodsystem.mapper;

import com.elec5619.bloodsystem.domain.MessageRecord;
import com.elec5619.bloodsystem.dto.MessageRecordResponseDTO;

public class MessageRecordMapper {
    public static MessageRecordResponseDTO map(MessageRecord messageRecord){
        return new MessageRecordResponseDTO(messageRecord.getSubject(),
                messageRecord.getContent(),
                messageRecord.getDate());
    }
}
