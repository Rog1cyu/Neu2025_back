package com.neuedu.nursehome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neuedu.nursehome.entity.Client;
import com.neuedu.nursehome.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public Page<Client> list(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "10") int size,
                             @RequestParam(required = false) String keyword,
                             @RequestParam(required = false) Integer bedId,
                             @RequestParam(required = false) Integer nurseId) {
        QueryWrapper<Client> wrapper = new QueryWrapper<>();
        if (keyword != null && !keyword.isEmpty()) {
            wrapper.lambda().like(Client::getName, keyword);
        }
        if (bedId != null) {
            wrapper.lambda().eq(Client::getBedId, bedId);
        }
        if (nurseId != null) {
            wrapper.lambda().eq(Client::getNurseId, nurseId);
        }
        return clientService.page(new Page<>(page, size), wrapper);
    }

    @PostMapping
    public boolean create(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Integer id, @RequestBody Client client) {
        client.setClientId(id);
        return clientService.updateById(client);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return clientService.removeById(id);
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Integer id) {
        return clientService.getById(id);
    }
}
