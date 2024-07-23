onbreak {quit -f}
onerror {quit -f}

vsim -t 1ps -lib xil_defaultlib outputBuffer_opt

do {wave.do}

view wave
view structure
view signals

do {outputBuffer.udo}

run -all

quit -force
