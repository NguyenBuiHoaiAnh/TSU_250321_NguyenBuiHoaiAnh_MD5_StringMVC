package ra.edu.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.edu.model.PaginationResult;
import ra.edu.model.Room;
import ra.edu.model.dto.RoomStatus;
import ra.edu.service.RoomService;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping
    public String listRooms(@RequestParam(name = "page", defaultValue = "1") int page,
                            @RequestParam(name = "size", defaultValue = "10") int size,
                            Model model) {
        PaginationResult<Room> pagination = roomService.getPaginationData(null, size, page);

        model.addAttribute("rooms", pagination.getDataList());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pagination.getTotalPages());
        model.addAttribute("pageSize", size);

        return "room/list";
    }

    @GetMapping("/add")
    public String initAddForm(Model model) {
        model.addAttribute("room", new Room());
        model.addAttribute("statuses", RoomStatus.values());
        return "room/add";
    }

    @PostMapping("/add")
    public String addRoom(@Valid @ModelAttribute("room") Room room,
                          BindingResult result,
                          @RequestParam("imgUrl") MultipartFile img,
                          Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statuses", RoomStatus.values());
            return "room/add";
        }

        // Upload
        if (img != null && !img.isEmpty()) {
            try {
                Map upload = cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap());
                room.setImage(upload.get("secure_url").toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        boolean success = roomService.addRoom(room);
        if (success) {
            return "redirect:/room";
        } else {
            model.addAttribute("errorMsg", "Thêm phòng thất bại");
            model.addAttribute("statuses", RoomStatus.values());
            return "room/add";
        }
    }

    @GetMapping("/edit/{id}")
    public String initEditForm(@PathVariable("id") int id, Model model) {
        Room room = roomService.findById(id);
        if (room == null) {
            return "redirect:/room";
        }
        model.addAttribute("room", room);
        model.addAttribute("statuses", RoomStatus.values());
        return "room/edit";
    }

    @PostMapping("/edit")
    public String editRoom(@Valid @ModelAttribute("room") Room room,
                           BindingResult result,
                           @RequestParam("imgUrl") MultipartFile img,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("statuses", RoomStatus.values());
            return "room/edit";
        }

        // Upload
        if (img != null && !img.isEmpty()) {
            try {
                Map upload = cloudinary.uploader().upload(img.getBytes(), ObjectUtils.emptyMap());
                room.setImage(upload.get("secure_url").toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        boolean success = roomService.updateRoom(room);
        if (success) {
            return "redirect:/room";
        } else {
            model.addAttribute("errorMsg", "Cập nhật phòng thất bại");
            model.addAttribute("statuses", RoomStatus.values());
            return "room/edit";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") int id) {
        boolean success = roomService.deleteRoom(id);
        if (success) {
            return "redirect:/room";
        } else  {
            return "redirect:/";
        }
    }
}
