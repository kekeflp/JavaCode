package org.service;

import org.entity.ManagerDO;

public interface IAdminService {
    boolean validateAdmin(ManagerDO user);
}
