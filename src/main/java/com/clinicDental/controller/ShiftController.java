package com.clinicDental.controller;
import com.clinicDental.persistence.entity.Shift;
import com.clinicDental.persistence.entity.dto.ShiftDto;
import com.clinicDental.service.IShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/shift")
public class ShiftController {
    @Autowired
    private IShiftService shiftService;


    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody Shift shift){
        Shift shift1=shiftService.save(shift);
        return new ResponseEntity<>(shift1, HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        shiftService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Shift id: "+id+" eliminated");
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<ShiftDto>> findAll(){

        List<ShiftDto>shiftDtoList=shiftService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(shiftDtoList);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<ShiftDto> findById(@PathVariable("id") Long id){

        ShiftDto shiftDto=shiftService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(shiftDto);
    }


    @PutMapping("/update/id/{id}")
    public ResponseEntity<Shift> update(@Valid @RequestBody Shift shift,@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(shiftService.update(shift,id));
    }

}
