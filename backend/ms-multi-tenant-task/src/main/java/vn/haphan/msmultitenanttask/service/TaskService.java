package vn.haphan.msmultitenanttask.service;

import org.springframework.stereotype.Service;
import vn.haphan.msmultitenanttask.bean.TenantContext;
import vn.haphan.msmultitenanttask.entity.Task;

/**
 * @author : Hà Phan
 * created date : 2/24/2026
 * project-name : ms-learn-spring40
 * package-name : vn.haphan.msmultitenanttask.service
 **/
@Service
public class TaskService {

    public Task create(Task task) {
        task.setTenantId(TenantContext.getTenant());
        return task;
    }
}
