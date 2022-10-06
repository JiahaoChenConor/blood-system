package com.elec5619.bloodsystem.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.elec5619.bloodsystem.dao.HealthInfoRepository;
import com.elec5619.bloodsystem.entity.BloodType;
import com.elec5619.bloodsystem.entity.HealthInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {HealthInfoService.class})
@ExtendWith(SpringExtension.class)
class HealthInfoServiceTest {
    @MockBean
    private HealthInfoRepository healthInfoRepository;

    @Autowired
    private HealthInfoService healthInfoService;

    /**
     * Method under test: {@link HealthInfoService#saveHealthInfo(HealthInfo)}
     */
    @Test
    void testSaveHealthInfo() {
        HealthInfo healthInfo = new HealthInfo();
        healthInfo.setAge(1);
        healthInfo.setBloodType(BloodType.A);
        healthInfo.setHealthInfoId(123L);
        when(healthInfoRepository.save((HealthInfo) any())).thenReturn(healthInfo);

        HealthInfo healthInfo1 = new HealthInfo();
        healthInfo1.setAge(1);
        healthInfo1.setBloodType(BloodType.A);
        healthInfo1.setHealthInfoId(123L);
        assertSame(healthInfo, healthInfoService.saveHealthInfo(healthInfo1));
        verify(healthInfoRepository).save((HealthInfo) any());
    }

    /**
     * Method under test: {@link HealthInfoService#updateBloodTypeById(Long, BloodType)}
     */
    @Test
    void testUpdateBloodTypeById() {
        doNothing().when(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
        healthInfoService.updateBloodTypeById(123L, BloodType.A);
        verify(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
    }

    /**
     * Method under test: {@link HealthInfoService#updateBloodTypeById(Long, BloodType)}
     */
    @Test
    void testUpdateBloodTypeById2() {
        doNothing().when(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
        healthInfoService.updateBloodTypeById(123L, BloodType.B);
        verify(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
    }

    /**
     * Method under test: {@link HealthInfoService#updateBloodTypeById(Long, BloodType)}
     */
    @Test
    void testUpdateBloodTypeById3() {
        doNothing().when(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
        healthInfoService.updateBloodTypeById(123L, BloodType.AB);
        verify(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
    }

    /**
     * Method under test: {@link HealthInfoService#updateBloodTypeById(Long, BloodType)}
     */
    @Test
    void testUpdateBloodTypeById4() {
        doNothing().when(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
        healthInfoService.updateBloodTypeById(123L, BloodType.O);
        verify(healthInfoRepository).updateBloodTypeById((BloodType) any(), (Long) any());
    }

    /**
     * Method under test: {@link HealthInfoService#updateAgeById(Long, Integer)}
     */
    @Test
    void testUpdateAgeById() {
        doNothing().when(healthInfoRepository).updateAgeById((Integer) any(), (Long) any());
        healthInfoService.updateAgeById(123L, 1);
        verify(healthInfoRepository).updateAgeById((Integer) any(), (Long) any());
    }
}

