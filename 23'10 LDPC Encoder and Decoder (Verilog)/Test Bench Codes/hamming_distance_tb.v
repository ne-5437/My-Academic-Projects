module hamming_distance_tb;

  reg [5:0] binary1;
  reg [5:0] binary2;
  wire [1:0]distance;
  
  
 hamming_distance uut(binary1, binary2, distance);
  initial begin
    
    binary1 = 6'b101010;
    binary2 = 6'b111111;
    
    #10; 
    
    $display("Binary1: %b", binary1);
    $display("Binary2: %b", binary2);
    $display("Hamming Distance: %d", distance);
    
    
    binary1 = 6'b000001;
    binary2 = 6'b000000;
    
    #10; 
    $display("Binary1: %b", binary1);
    $display("Binary2: %b", binary2);
    $display("Hamming Distance: %d", distance);
    
    
    
    $finish; 
  end

endmodule