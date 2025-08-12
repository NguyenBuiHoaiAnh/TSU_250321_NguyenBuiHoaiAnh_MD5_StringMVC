package ra.edu.controller;

import ra.edu.model.Transaction;
import ra.edu.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("transactions")
public class TransactionController {

    @ModelAttribute("transactions")
    public List<Transaction> initTransactions() {
        return new ArrayList<>();
    }

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String showTransaction(@ModelAttribute("transactions") List<Transaction> transactionList,
                                  Model model) {
        System.out.println("Lỗi ở controller list");
        model.addAttribute("transactions", transactionList);
        return "listTr";
    }

    @GetMapping("/add")
    public String initAddTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "addTr";
    }

    @PostMapping("/add")
    public String addTransaction(@Valid @ModelAttribute("transaction") Transaction transaction,
                                 BindingResult result,
                                 @ModelAttribute("transactions") List<Transaction> transactionList) {
        if (result.hasErrors()) {
            return "addTr";
        }
        transactionService.addTransaction(transactionList, transaction);
        return "redirect:/";
    }

    @GetMapping("/editPage/{id}")
    public String initEditTransaction(@PathVariable("id") int id,
                                      @ModelAttribute("transactions") List<Transaction> transactionList,
                                      Model model) {
        Transaction transactionEdit = transactionService.findTransactionById(id, transactionList);
        if (transactionEdit == null) {
            return "listTr";
        } else {
            model.addAttribute("transaction", transactionEdit);
            return "editTr";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateTransaction(@PathVariable("id") int id,
                                    @ModelAttribute("transactions") List<Transaction> transactionList,
                                    @Valid @ModelAttribute("transaction") Transaction transactionUpdate,
                                    BindingResult result) {
        if (result.hasErrors()) {
            return "addTr";
        }
        transactionService.editTransaction(id, transactionList, transactionUpdate);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable("id") int id,
                                    @ModelAttribute("transactions") List<Transaction> transactionList) {
        transactionService.deleteTransaction(id, transactionList);
        return "redirect:/";
    }
}
