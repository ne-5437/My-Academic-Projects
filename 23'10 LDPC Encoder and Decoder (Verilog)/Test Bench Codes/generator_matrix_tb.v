module generator_matrix_tb;
reg [5:0]h1,h2,h3;
reg en;
wire [5:0]g1,g2,g3;
generator_matrix uut(en,h1,h2,h3,g1,g2,g3);
initial
begin
en=0;
#1 en=1;
#10 h1=6'b 110100;h2=6'b 011010;h3=6'b 101001;
#10 $finish;
end
endmodule