package com.andreseptian.usermanagement.service.implementation;

import com.andreseptian.usermanagement.domain.Customer;
import com.andreseptian.usermanagement.domain.Invoice;
import com.andreseptian.usermanagement.domain.Stats;
import com.andreseptian.usermanagement.repository.CustomerRepository;
import com.andreseptian.usermanagement.repository.InvoiceRepository;
import com.andreseptian.usermanagement.rowmapper.StatsRowMapper;
import com.andreseptian.usermanagement.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

import static com.andreseptian.usermanagement.query.CustomerQuery.*;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;
    private final NamedParameterJdbcTemplate jdbc;


    @Override
    public Customer createCustomer(Customer customer) {
        customer.setCreatedAt(new Date());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getCustomers(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> searchCustomers(String name, int page, int size) {
        return customerRepository.findByNameContaining(name, of(page, size));
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoice.setInvoiceNumber(randomAlphanumeric(8).toUpperCase());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Page<Invoice> getInvoices(int page, int size) {
        return invoiceRepository.findAll(of(page, size));
    }

    @Override
    public void addInvoiceToCustomer(Long id, Invoice invoice) {
        invoice.setInvoiceNumber(randomAlphanumeric(8).toUpperCase());
        Customer customer = customerRepository.findById(id).get();
        invoice.setCustomer(customer);
        invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public Stats getStats() {
        return jdbc.queryForObject(STATS_QUERY, Map.of(), new StatsRowMapper());
    }
}
